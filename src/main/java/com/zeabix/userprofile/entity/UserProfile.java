package com.zeabix.userprofile.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class UserProfile {
    @Id
    private String id;

    private String userId;
    private String email;
    private String firstName;
    private String lastName;
    private String avatarUrl;

}
