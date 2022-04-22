package com.zeabix.userprofile.dto;

public class UserProfileDTOBuilder {
    private UserProfileDTO dto;

    private UserProfileDTOBuilder(){
        dto = new UserProfileDTO();
    }

    public static UserProfileDTOBuilder builder(){
        return new UserProfileDTOBuilder();
    }

    public UserProfileDTOBuilder ID(String id){
        dto.setId(id);
        return this;
    }

    public UserProfileDTO build(){
        return dto;
    }

}
