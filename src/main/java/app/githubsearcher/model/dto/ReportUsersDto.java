package app.githubsearcher.model.dto;

public class ReportUsersDto {

    private String login;
    private String email;
    private String name;
    private Boolean isHireable;
    private String gitHubUrl;
    private Integer numRepos;
    private Integer numContributions;
    private String location;
    private String avatarUrl;

    public ReportUsersDto(String login, String location, String email, String name, Boolean isHireable, String gitHubUrl, Integer numRepos, Integer numContributions, String avatarUrl) {
        this.login = login;
        this.location = location;
        this.email = email;
        this.name = name;
        this.isHireable = isHireable;
        this.gitHubUrl = gitHubUrl;
        this.numRepos = numRepos;
        this.numContributions = numContributions;
        this.avatarUrl = avatarUrl;
    }

    public ReportUsersDto() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsHireable() {
        return isHireable;
    }

    public void setIsHireable(Boolean isHireable) {
        this.isHireable = isHireable;
    }

    public String getGitHubUrl() {
        return gitHubUrl;
    }

    public void setGitHubUrl(String gitHubUrl) {
        this.gitHubUrl = gitHubUrl;
    }

    public Integer getNumRepos() {
        return numRepos;
    }

    public void setNumRepos(Integer numRepos) {
        this.numRepos = numRepos;
    }

    public Integer getNumContributions() {
        return numContributions;
    }

    public void setNumContributions(Integer numContributions) {
        this.numContributions = numContributions;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

}
