package com.zeabix.userprofile.service;

import com.zeabix.userprofile.entity.UserProfile;
import com.zeabix.userprofile.repository.UserProfileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static reactor.core.publisher.Mono.when;

@ExtendWith(MockitoExtension.class)
class SimpleUserProfileServiceTest {
    @Mock
    private UserProfileRepository userProfileRepository;

    @InjectMocks
    private final SimpleUserProfileService userProfileService = new SimpleUserProfileService(userProfileRepository);


    //@Test
    void createUserProfile() {
        UserProfile profile = new UserProfile();
        profile.setUserId("test001");
        profile.setFirstName("FirstName");
        profile.setLastName("LastName");

        when(userProfileRepository.save(profile)).thenReturn(Mono.just(profile));
        UserProfile savedMono = userProfileService.createUserProfile(profile).block();
        assertEquals(profile.getFirstName(), savedMono.getFirstName());
        assertEquals(profile.getLastName(), savedMono.getLastName());
    }

    //@Test
    void getUserProfileDetail(){
        when(userProfileRepository.findById(Mockito.anyString())).thenReturn(Mono.empty());
        Optional<UserProfile> profileOpt = userProfileService.getUserProfileDetail("test").blockOptional();
        assertTrue(profileOpt.isEmpty());
    }
}