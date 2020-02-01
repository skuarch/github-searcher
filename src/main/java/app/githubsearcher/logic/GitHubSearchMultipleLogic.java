package app.githubsearcher.logic;

import app.githubsearcher.model.dto.GitHubUser;
import app.githubsearcher.model.dto.ReportUsersDto;
import app.githubsearcher.model.dto.UserDto;
import app.githubsearcher.service.GitHubUserService;
import app.githubsearcher.service.ReportUserDtoService;
import app.githubsearcher.service.TokenService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GitHubSearchMultipleLogic {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ReportUserDtoService reportUsersDtoService;

    @Autowired
    private GitHubUserService gitHubUserService;

    public List<ReportUsersDto> searchMultipleUsers(List<UserDto> users) {

        // get users
        List<GitHubUser> gitHubUsers = gitHubUserService.getGitHubUsers(users);

        // get profiles        
        gitHubUsers = gitHubUserService.getGitHubProfiles(gitHubUsers);

        // get repos        
        gitHubUsers = gitHubUserService.getGitHubAddRepos(gitHubUsers);

        // filter repos
        gitHubUsers = gitHubUserService.filterRepostByOwner(gitHubUsers);

        // get commits
        gitHubUsers = gitHubUserService.addCommitsToRepos(gitHubUsers);

        // count contributions
        gitHubUsers = gitHubUserService.countCommits(gitHubUsers);

        // generate report
        List<ReportUsersDto> report = reportUsersDtoService
                .generateReport(gitHubUsers);

        log.info("total requests: {}", tokenService.getTotalRequests());

        return report;
    }

}
