package app.githubsearcher.model.dto;

import java.util.List;

public class GitHubRepo {

    private String name;
    private String full_name;
    private String url = "";
    private String branches = url + "/branches";
    private String html_url;
    private GitHubOwner owner;
    private String language;
    private Integer commitsNumber = 0;
    private List<GitHubCommits> commits;
    private Boolean fork;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBranches() {
        return branches;
    }

    public void setBranches(String branches) {
        this.branches = branches;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public GitHubOwner getOwner() {
        return owner;
    }

    public void setOwner(GitHubOwner owner) {
        this.owner = owner;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getCommitsNumber() {
        return commitsNumber;
    }

    public void setCommitsNumber(Integer commitsNumber) {
        this.commitsNumber = commitsNumber;
    }

    public List<GitHubCommits> getCommits() {
        return commits;
    }

    public void setCommits(List<GitHubCommits> commits) {
        this.commits = commits;
    }

    public Boolean getFork() {
        return fork;
    }

    public void setFork(Boolean fork) {
        this.fork = fork;
    }

}
