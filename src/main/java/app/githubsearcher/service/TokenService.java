package app.githubsearcher.service;

import app.githubsearcher.model.entity.Token;
import app.githubsearcher.model.repository.TokenRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.binary.Base64;

@Service
public class TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    private static Byte numRequest = 1;
    private static Byte tokenIndex = 0;
    private static Integer totalRequests = 0;
    private static Boolean decoded = false;

    public String getTokenRotated() {

        totalRequests++;

        List<Token> tokens = getTokens();        

        if (numRequest > 4) {
            tokenIndex++;
            numRequest = 0;
            if (tokenIndex >= tokens.size()) {
                tokenIndex = 0;
            }
        }

        numRequest++;        
        Token token = tokens.get(tokenIndex);
        return token.getToken();

    }

    public List<Token> getTokens() {
        List<Token> tokens = tokenRepository.findAll();
        List<Token> tokensDecoded = getDecodeTokens(tokens);
        return tokensDecoded;
    }

    public Integer getTotalRequests() {
        return totalRequests;
    }
    
    public List<Token> getDecodeTokens(List<Token> tokens) {
        
        if(decoded) {
           return tokens; 
        }
        
        decoded = true;        
        List<Token> newTokens = new ArrayList<>();
        
        for (Token token : tokens) {            
            String tokenDecoded = new String(
                    new Base64().decode(token.getToken())
            );            
            token.setToken(tokenDecoded);
            newTokens.add(token);
        }
        return newTokens;
    }

}
