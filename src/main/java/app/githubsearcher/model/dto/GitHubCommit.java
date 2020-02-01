package app.githubsearcher.model.dto;

public class GitHubCommit {

    private GitHubAuthor author;
    private GitHubCommiter commiter;
    private String message;

    public GitHubCommit() {
    }

    public GitHubAuthor getAuthor() {
        return author;
    }

    public void setAuthor(GitHubAuthor author) {
        this.author = author;
    }

    public GitHubCommiter getCommiter() {
        return commiter;
    }

    public void setCommiter(GitHubCommiter commiter) {
        this.commiter = commiter;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
