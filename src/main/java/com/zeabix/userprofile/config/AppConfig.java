package com.zeabix.userprofile.config;

import com.zeabix.userprofile.repository.UserProfileRepository;
import com.zeabix.userprofile.service.IUserProfileService;
import com.zeabix.userprofile.service.SimpleUserProfileService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    @ConditionalOnMissingBean
    public IUserProfileService userProfileService(UserProfileRepository repository){
        return new SimpleUserProfileService(repository);
    }
}
