package app.githubsearcher.service;

import app.githubsearcher.model.dto.GitHubCommits;
import app.githubsearcher.model.dto.GitHubProfile;
import app.githubsearcher.model.dto.GitHubRepo;
import app.githubsearcher.model.dto.GitHubUser;
import app.githubsearcher.model.dto.UserDto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GitHubUserService {

    @Autowired
    private GithubSearchService githubSearchService;

    @Autowired
    private GitHubProfileService gitHubProfileService;

    @Autowired
    private GitHubRepoService gitHubRepoService;

    @Autowired
    private GitHubCommitsService gitHubCommitsService;

    public List<GitHubUser> getGitHubUsers(List<UserDto> users) {

        List<GitHubUser> ghUsers = new ArrayList<>();
        List<GitHubUser> usrs;

        for (UserDto user : users) {

            if (!user.getLocation().isEmpty()) {
                usrs = githubSearchService
                        .searchUserByLocation(user.getFirstName(), user.getLastName(), user.getLocation())
                        .getItems();
            } else {
                usrs = githubSearchService
                        .searchUser(user.getFirstName(), user.getLastName())
                        .getItems();
            }

            ghUsers.addAll(usrs);
        }

        return ghUsers;

    }

    public List<GitHubUser> getGitHubProfiles(List<GitHubUser> gitHubUsers) {

        List<GitHubUser> users = new ArrayList();

        for (GitHubUser gitHubUser : gitHubUsers) {
            GitHubProfile profile = gitHubProfileService.getGitHubProfile(gitHubUser.getLogin());
            gitHubUser.setProfile(profile);
            users.add(gitHubUser);
        }

        return users;

    }

    public List<GitHubUser> getGitHubAddRepos(List<GitHubUser> gitHubUsers) {

        List<GitHubUser> users = new ArrayList<>();

        for (GitHubUser gitHubUser : gitHubUsers) {
            String login = gitHubUser.getLogin();
            List<GitHubRepo> repos = gitHubRepoService.getGitHubRepoNext(login);
            gitHubUser.setRepos(repos);
            users.add(gitHubUser);
        }

        return users;

    }

    public List<GitHubUser> filterRepostByOwner(List<GitHubUser> users) {

        for (GitHubUser user : users) {

            List<GitHubRepo> r = filter(user.getLogin(), user.getRepos());
            user.setRepos(r);

        }

        return users;

    }

    public List<GitHubRepo> filter(String login, List<GitHubRepo> repos) {
        List<GitHubRepo> filteredRepost = repos
                .stream()
                .filter(r -> r.getOwner().getLogin().equalsIgnoreCase(login))
                .collect(Collectors.toList());
        return filteredRepost;
    }

    public List<GitHubUser> addCommitsToRepos(List<GitHubUser> users) {

        for (GitHubUser user : users) {
            List<GitHubRepo> repos = user.getRepos();
            List<GitHubRepo> r = gitHubCommitsService.addCommitsNext(repos);
            user.setRepos(r);
        }

        return users;
    }

    public List<GitHubUser> countCommits(List<GitHubUser> gitHubUsers) {

        Integer count = 0;

        for (GitHubUser gitHubUser : gitHubUsers) {

            List<GitHubRepo> repos = gitHubUser.getRepos();

            for (GitHubRepo repo : repos) {
                List<GitHubCommits> commits = repo.getCommits();

                if (commits != null) {
                    count += commits.size();
                }

                gitHubUser.setNumContributions(count);
            }

            count = 0;
        }

        return gitHubUsers;

    }

}
