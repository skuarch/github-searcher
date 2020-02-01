package app.githubsearcher.model.dto;

import java.util.List;

public class GitHubSearchDto {

    private Integer total_count;
    private List<GitHubUser> items;

    public Integer getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Integer total_count) {
        this.total_count = total_count;
    }

    public List<GitHubUser> getItems() {
        return items;
    }

    public void setItems(List<GitHubUser> items) {
        this.items = items;
    }

}
