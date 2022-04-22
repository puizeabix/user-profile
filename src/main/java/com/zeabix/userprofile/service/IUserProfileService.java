package com.zeabix.userprofile.service;

import com.zeabix.userprofile.entity.UserProfile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IUserProfileService {

    Mono<UserProfile> createUserProfile(UserProfile profile);
    Mono<UserProfile> getUserProfileDetail(String id);
    Flux<UserProfile> listUserProfiles();

}
