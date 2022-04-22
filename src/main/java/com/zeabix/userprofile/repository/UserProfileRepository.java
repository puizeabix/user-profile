package com.zeabix.userprofile.repository;

import com.zeabix.userprofile.entity.UserProfile;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends ReactiveMongoRepository<UserProfile, String> {
}
