package com.zeabix.userprofile.service;

import com.zeabix.userprofile.entity.UserProfile;
import com.zeabix.userprofile.repository.UserProfileRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class SimpleUserProfileService implements IUserProfileService{
    private final UserProfileRepository repository;

    public SimpleUserProfileService(UserProfileRepository repository){
        this.repository = repository;
    }

    @Override
    public Mono<UserProfile> createUserProfile(UserProfile profile) {
        return null;
    }

    @Override
    public Mono<UserProfile> getUserProfileDetail(String id) {
        return null;
    }

    @Override
    public Flux<UserProfile> listUserProfiles() {
        return null;
    }
}
