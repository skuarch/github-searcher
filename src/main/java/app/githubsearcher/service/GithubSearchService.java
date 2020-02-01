package app.githubsearcher.service;

import app.githubsearcher.model.dto.GitHubSearchDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class GithubSearchService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UrlService urlService;

    @Autowired
    private HeaderService headerService;

    public GitHubSearchDto searchUser(String firstName, String lastName) {

        String url = urlService.getGitHubUrlUsers(firstName, lastName);
        log.info(url);
        HttpEntity entity = new HttpEntity(headerService.getAuthHeader());
        ResponseEntity<GitHubSearchDto> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, GitHubSearchDto.class);

        GitHubSearchDto dto = response.getBody();
        return dto;

    }

    public GitHubSearchDto searchUserByLocation(String firstName, String lastName, String location) {

        String url = urlService.getGitHubUrlUsers(firstName, lastName, location);
        log.info(url);
        GitHubSearchDto dto = restTemplate
                .getForObject(url, GitHubSearchDto.class);

        return dto;

    }

}
