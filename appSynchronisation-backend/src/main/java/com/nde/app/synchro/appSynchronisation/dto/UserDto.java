package com.nde.app.synchro.appSynchronisation.dto;

import com.nde.app.synchro.appSynchronisation.dto.mysqldto.MysqlUserDto;
import com.nde.app.synchro.appSynchronisation.dto.h2dto.H2UserDto;
import com.nde.app.synchro.appSynchronisation.entities.UserEntity;
import com.nde.app.synchro.appSynchronisation.entities.h2entities.H2UserEntity;
import com.nde.app.synchro.appSynchronisation.entities.mysqlentities.MysqlUserEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private Integer id;

    private String lastName;

    private String firstName;

    private String birth;

    private String email;

    private String pwd;

    private String phone;


    public static UserDto fromEntity(UserEntity user){
        if(user == null){
            return null;
        }
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birth(user.getBirth())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();
    }

    public static UserEntity toEntity(UserDto user){
        if(user == null){
            return null;
        }
        return UserEntity.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birth(user.getBirth())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();
    }

    public static MysqlUserDto toMysqlUserDto(UserDto user){
        if(user == null){
            return null;
        }
        return MysqlUserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birth(user.getBirth())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();
    }

    public static H2UserDto toSqliteUserDto(UserDto user){
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

    public static UserDto toUserDto(H2UserDto h2UserDto){
        if(h2UserDto == null){
            return null;
        }
        return UserDto.builder()
                .id(h2UserDto.getId())
                .firstName(h2UserDto.getFirstName())
                .lastName(h2UserDto.getLastName())
                .birth(h2UserDto.getBirth())
                .email(h2UserDto.getEmail())
                .phone(h2UserDto.getPhone())
                .build();
    }

    public static UserDto fromH2UserEntity(H2UserEntity h2UserEntity){
        if(h2UserEntity == null){
            return null;
        }
        return UserDto.builder()
                .id(h2UserEntity.getId())
                .firstName(h2UserEntity.getFirstName())
                .lastName(h2UserEntity.getLastName())
                .birth(h2UserEntity.getBirth())
                .email(h2UserEntity.getEmail())
                .phone(h2UserEntity.getPhone())
                .build();
    }

    public static MysqlUserEntity toMysqlUserEntity(UserDto userDto){
        if(userDto == null){
            return null;
        }
        return MysqlUserEntity.builder()
                .id(userDto.getId())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .birth(userDto.getBirth())
                .email(userDto.getEmail())
                .phone(userDto.getPhone())
                .build();
    }
}
