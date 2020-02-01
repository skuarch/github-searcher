package app.githubsearcher.service;

import app.githubsearcher.model.entity.Config;
import app.githubsearcher.model.repository.ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {

    @Autowired
    private ConfigRepository repository;

    @Autowired
    private Environment environment;

    public Config getDefaultConfig() {
        Long activeConfigNum = environment.getProperty("active.config.num", Long.class);
        Config config = repository.getOne(activeConfigNum);
        return config;
    }

}
