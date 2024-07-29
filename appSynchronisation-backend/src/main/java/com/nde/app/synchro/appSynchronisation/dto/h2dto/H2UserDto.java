package com.nde.app.synchro.appSynchronisation.dto.h2dto;

import com.nde.app.synchro.appSynchronisation.entities.h2entities.H2UserEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class H2UserDto {

    private Integer id;

    private String lastName;

    private String firstName;

    private String birth;

    private String email;

    private String pwd;

    private String phone;


    public static H2UserDto fromEntity(H2UserEntity user){
        if(user == null){
            return null;
        }
        return H2UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birth(user.getBirth())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();
    }

    public static H2UserEntity toEntity(H2UserDto user){
        if(user == null){
            return null;
        }
        return H2UserEntity.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birth(user.getBirth())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();
    }
}
