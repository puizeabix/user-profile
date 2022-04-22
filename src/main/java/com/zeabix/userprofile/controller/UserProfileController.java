package com.zeabix.userprofile.controller;

import com.zeabix.userprofile.dto.UserProfileDTO;
import com.zeabix.userprofile.dto.UserProfileDTOMapper;
import com.zeabix.userprofile.exception.UserNotFoundException;
import com.zeabix.userprofile.service.IUserProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j(topic = "USER-PROFILE-CONTROLLER")
@SuppressWarnings("unused")
@RestController
@RequestMapping(value = "/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserProfileController {
    private final IUserProfileService userProfileService;

    @Autowired
    public UserProfileController(IUserProfileService userProfileService){
        this.userProfileService = userProfileService;
    }

    @GetMapping("/profiles/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<UserProfileDTO> getUserProfileDetail(@PathVariable String id){
        log.info("Get user profile with id: {}", id);
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        return userProfileService.getUserProfileDetail(id)
                .map(UserProfileDTOMapper.entityToDTO)
                .switchIfEmpty(Mono.error(new UserNotFoundException()));
    }

    @GetMapping("/profiles")
    @ResponseStatus(HttpStatus.OK)
    public Flux<UserProfileDTO> getAllUserProfiles(){
        log.info("Get all user profiles");
        return userProfileService.listUserProfiles()
                .map(UserProfileDTOMapper.entityToDTO);
    }

    @PostMapping("/profiles")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<UserProfileDTO> createUserProfile(@RequestBody UserProfileDTO request) {
        log.info("Create new user profile");
        return userProfileService.createUserProfile(UserProfileDTOMapper.dtoToEntity.apply(request))
                .map(UserProfileDTOMapper.entityToDTO);
    }

    @GetMapping("health")
    @ResponseStatus(HttpStatus.OK)
    public Mono<String> healthCheck(){
        return Mono.just("OK");
    }

}
