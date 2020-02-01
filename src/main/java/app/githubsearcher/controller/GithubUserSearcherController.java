package app.githubsearcher.controller;

import app.githubsearcher.logic.GitHubSearchMultipleLogic;
import app.githubsearcher.model.constants.EndPoints;
import app.githubsearcher.model.dto.ReportUsersDto;
import app.githubsearcher.model.dto.UserDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndPoints.GITHUB_SEARCH)
public class GithubUserSearcherController {

    @Autowired
    private GitHubSearchMultipleLogic gitHubSearchMultipleLogic;

    @PostMapping
    public ResponseEntity<List<ReportUsersDto>> searchGithubUser(
            @RequestBody List<UserDto> users) {

        return ResponseEntity.ok(gitHubSearchMultipleLogic.searchMultipleUsers(users));

    }

}
