package app.githubsearcher.model.dto;

public class GitHubCommits {

    private String sha;
    private GitHubCommit commit;
    private GitHubUser author;
    private GitHubUser committer;

    public GitHubCommits() {
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public GitHubCommit getCommit() {
        return commit;
    }

    public void setCommit(GitHubCommit commit) {
        this.commit = commit;
    }

    public GitHubUser getAuthor() {
        return author;
    }

    public void setAuthor(GitHubUser author) {
        this.author = author;
    }

    public GitHubUser getCommitter() {
        return committer;
    }

    public void setCommitter(GitHubUser committer) {
        this.committer = committer;
    }

}
