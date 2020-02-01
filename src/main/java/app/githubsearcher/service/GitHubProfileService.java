package app.githubsearcher.service;

import app.githubsearcher.model.dto.GitHubProfile;
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
public class GitHubProfileService {

    @Autowired
    private UrlService urlService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HeaderService headerService;

    public GitHubProfile getGitHubProfile(String login) {

        String url = urlService.getGitHubProfileUrl(login);
        log.info(url);
        HttpHeaders headers = headerService.getAuthHeader();
        HttpEntity requestEntity = new HttpEntity(headers);
        ResponseEntity<GitHubProfile> responseEntity = restTemplate
                .exchange(
                        url,
                        HttpMethod.GET,
                        requestEntity,
                        GitHubProfile.class
                );
        GitHubProfile profile = responseEntity.getBody();
        return profile;

    }

}
