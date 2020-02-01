package app.githubsearcher.service;

import app.githubsearcher.model.dto.GitHubProfile;
import app.githubsearcher.model.dto.GitHubUser;
import app.githubsearcher.model.dto.ReportUsersDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ReportUserDtoService {

    public List<ReportUsersDto> generateReport(List<GitHubUser> users) {

        List<ReportUsersDto> dtos = new ArrayList<>();

        users.stream().map((user) -> {
            GitHubProfile profile = user.getProfile();
            ReportUsersDto dto = new ReportUsersDto(
                    user.getLogin(),
                    profile.getLocation(),
                    profile.getEmail(),
                    profile.getName(),
                    profile.isHireable(),
                    profile.getHtml_url(),
                    user.getRepos().size(),
                    user.getNumContributions(),
                    profile.getAvatar_url());
            return dto;
        }).forEachOrdered((dto) -> {
            dtos.add(dto);
        });

        return dtos;

    }

}
