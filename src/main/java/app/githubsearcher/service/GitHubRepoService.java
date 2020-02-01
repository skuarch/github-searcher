package app.githubsearcher.service;

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
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class GitHubRepoService {

    @Autowired
    private UrlService urlService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HeaderService headerService;

    public List<GitHubRepo> getGitHubRepoNext(String login) {

        List<GitHubRepo> repos = new ArrayList<>();

        for (int page = 1;; page++) {

            String url = urlService.getGitHubReposUrl(login, page);
            log.info(url);
            HttpHeaders headers = headerService.getAuthHeader();
            HttpEntity requestEntity = new HttpEntity(headers);
            ResponseEntity<GitHubRepo[]> responseEntity = restTemplate
                    .exchange(
                            url,
                            HttpMethod.GET,
                            requestEntity,
                            GitHubRepo[].class
                    );

            List<GitHubRepo> reposResult = Arrays.asList(responseEntity.getBody());
            reposResult = removeForkedRepos(reposResult);
            repos.addAll(reposResult);
            HttpHeaders responseHeaders = responseEntity.getHeaders();

            if (!headerService.hasNext(responseHeaders)) {
                break;
            }

        }

        return repos;

    }

    public List<GitHubRepo> removeForkedRepos(List<GitHubRepo> repos) {

        List<GitHubRepo> newRepos = new ArrayList<>();

        for (GitHubRepo repo : repos) {
            if (!repo.getFork()) {
                newRepos.add(repo);
            }
        }

        return newRepos;

    }

}
