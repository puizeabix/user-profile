package com.zeabix.userprofile.entity;

public class UserProfileBuilder {
    private UserProfile entity;

    private UserProfileBuilder(){
        entity = new UserProfile();
    }

    public static UserProfileBuilder builder(){
        return new UserProfileBuilder();
    }

    public UserProfileBuilder ID(String id){
        entity.setId(id);
        return this;
    }

    public UserProfile build(){
        return entity;
    }
}
