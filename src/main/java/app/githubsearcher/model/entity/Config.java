package app.githubsearcher.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "config")
public class Config {

    @Id
    @Column(name = "config_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "config_github_url")
    private String gitHubUrl;

    @Column(name = "config_github_uri_search")
    private String gitHubUriSearch;

    @Column(name = "config_github_uri_users")
    private String gitHubUriUsers;

    @Column(name = "config_github_uri_repos")
    private String gitHubUriRepos;

    public Config() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGitHubUrl() {
        return gitHubUrl;
    }

    public void setGitHubUrl(String gitHubUrl) {
        this.gitHubUrl = gitHubUrl;
    }

    public String getGitHubUriSearch() {
        return gitHubUriSearch;
    }

    public void setGitHubUriSearch(String gitHubUriSearch) {
        this.gitHubUriSearch = gitHubUriSearch;
    }

    public String getGitHubUriUsers() {
        return gitHubUriUsers;
    }

    public void setGitHubUriUsers(String gitHubUriUsers) {
        this.gitHubUriUsers = gitHubUriUsers;
    }

    public String getGitHubUriRepos() {
        return gitHubUriRepos;
    }

    public void setGitHubUriRepos(String gitHubUriRepos) {
        this.gitHubUriRepos = gitHubUriRepos;
    }

}
