package app.githubsearcher.model.dto;

public class GitHubOwner {

    private String login;

    public GitHubOwner() {

    }

    public GitHubOwner(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
