package app.githubsearcher.model.dto;

import java.util.List;

public class GitHubUser {

    private String login;
    private Integer id;
    private String avatar_url;
    private String url;
    private String repos_url;
    private Float score;
    private List<GitHubRepo> repos;
    private GitHubProfile profile;
    private Integer numContributions = 0;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public void setRepos_url(String repos_url) {
        this.repos_url = repos_url;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public List<GitHubRepo> getRepos() {
        return repos;
    }

    public void setRepos(List<GitHubRepo> repos) {
        this.repos = repos;
    }

    public GitHubProfile getProfile() {
        return profile;
    }

    public void setProfile(GitHubProfile profile) {
        this.profile = profile;
    }

    public Integer getNumContributions() {
        return numContributions;
    }

    public void setNumContributions(Integer numContributions) {
        this.numContributions = numContributions;
    }

}
