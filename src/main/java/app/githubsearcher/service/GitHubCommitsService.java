package app.githubsearcher.service;

import app.githubsearcher.model.dto.GitHubCommits;
import app.githubsearcher.model.dto.GitHubRepo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class GitHubCommitsService {

    @Autowired
    private HeaderService headerService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UrlService urlService;

    public List<GitHubRepo> addCommitsNext(List<GitHubRepo> repos) {

        for (GitHubRepo repo : repos) {

            List<GitHubCommits> commits = new ArrayList<>();

            for (int page = 1;; page++) {

                try {

                    String login = repo.getOwner().getLogin();
                    String repoName = repo.getName();
                    String url = urlService.getGitHubCommitsUrl(login, repoName, page);
                    log.info(url);
                    HttpHeaders headers = headerService.getAuthHeader();
                    HttpEntity entity = new HttpEntity(headers);
                    ResponseEntity<GitHubCommits[]> responseEntity = restTemplate
                            .exchange(url, HttpMethod.GET, entity, GitHubCommits[].class);
                    commits.addAll(Arrays.asList(responseEntity.getBody()));
                    repo.setCommitsNumber(commits.size());
                    HttpHeaders responseHeaders = responseEntity.getHeaders();

                    if(!headerService.hasNext(responseHeaders)) {
                        break;
                    }

                } catch (HttpClientErrorException e) {
                    log.error("posible repo with no commits, exception: {}", e.getMessage());
                    break;
                }

            }

            repo.setCommits(commits);
            repo.setCommitsNumber(commits.size());

        }

        return repos;

    }    

}
