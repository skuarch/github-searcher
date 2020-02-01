package app.githubsearcher.service;

import app.githubsearcher.model.entity.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

    @Autowired
    private ConfigService configService;

    public String getGitHubApiUrl() {
        Config config = configService.getDefaultConfig();
        String url = config.getGitHubUrl();
        return url;
    }

    public String getGitHubUrlSearchUsers() {
        Config config = configService.getDefaultConfig();
        StringBuilder sb = new StringBuilder();
        sb.append(config.getGitHubUrl())
                .append(config.getGitHubUriSearch())
                .append(config.getGitHubUriUsers());
        return sb.toString();
    }

    public String getGitHubUrlUsers(String firstName, String lastName) {
        String url = getGitHubUrlSearchUsers();
        StringBuilder sb = new StringBuilder();
        sb.append(url)
                .append("?q=")
                .append(firstName)
                .append(" ")
                .append(lastName);

        return sb.toString();
    }

    public String getGitHubUrlUsers(String firstName, String lastName, String location) {
        String url = getGitHubUrlSearchUsers();
        StringBuilder sb = new StringBuilder();
        sb.append(url)
                .append("?q=")
                .append(firstName)
                .append(" ")
                .append(lastName)
                .append(" in:fullname&location:=")
                .append(location);

        return sb.toString();
    }

    public String getGitHubProfileUrl(String login) {

        String url = getGitHubApiUrl();
        StringBuilder sb = new StringBuilder();
        sb.append(url)
                .append("/users/")
                .append(login);
        return sb.toString();

    }

    String getGitHubReposUrl(String login, Integer page) {
        String url = getGitHubApiUrl();
        StringBuilder sb = new StringBuilder();
        sb.append(url)
                .append("/users/")
                .append(login)
                .append("/repos")
                .append("?per_page=100")
                .append("&page=")
                .append(page);

        return sb.toString();
    }

    String getGitHubCommitsUrl(String login, String repoName, Integer page) {
        String url = getGitHubApiUrl();
        StringBuilder sb = new StringBuilder();
        sb.append(url)
                .append("/repos/")
                .append(login)
                .append("/")
                .append(repoName)
                .append("/")
                .append("commits")
                .append("?per_page=100")
                .append("&page=")
                .append(page);

        return sb.toString();
    }

}
