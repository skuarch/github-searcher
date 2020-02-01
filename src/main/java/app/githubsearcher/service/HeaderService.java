package app.githubsearcher.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
public class HeaderService {

    @Autowired
    private TokenService tokenService;

    public HttpHeaders getAuthHeader() {
        HttpHeaders headers = new HttpHeaders();        
        headers.add("Authorization", "token " + tokenService.getTokenRotated());
        return headers;
    }
    
    public Boolean hasNext(HttpHeaders responseHeaders) {
        
        Boolean flag = true;
        
        if (responseHeaders != null) {
            List<String> r = responseHeaders.get("Link");
            if (r == null || r.size() < 1) {
                flag = false;
            } else if (!r.get(0).contains("next")) {
                flag = false;
            }
        }
        
        return flag;
                 
    }

}
