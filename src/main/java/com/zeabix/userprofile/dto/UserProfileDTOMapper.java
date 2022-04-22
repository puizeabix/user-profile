package com.zeabix.userprofile.dto;

import com.zeabix.userprofile.entity.UserProfile;
import com.zeabix.userprofile.entity.UserProfileBuilder;

import java.util.function.Function;

public class UserProfileDTOMapper {
    public static Function<UserProfile, UserProfileDTO> entityToDTO = (entity) -> UserProfileDTOBuilder.builder()
            .ID(entity.getId())
            .build();

    public static Function<UserProfileDTO, UserProfile> dtoToEntity = (dto) -> UserProfileBuilder.builder()
            .ID(dto.getId())
            .build();
}
