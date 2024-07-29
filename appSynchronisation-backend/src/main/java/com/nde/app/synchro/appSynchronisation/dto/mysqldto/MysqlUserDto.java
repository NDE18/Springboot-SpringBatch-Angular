package com.nde.app.synchro.appSynchronisation.dto.mysqldto;

import com.nde.app.synchro.appSynchronisation.dto.AddressDto;
import com.nde.app.synchro.appSynchronisation.entities.mysqlentities.MysqlUserEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MysqlUserDto {

    private Integer id;

    private String lastName;

    private String firstName;

    private String birth;

    private String image;

    private String email;

    private String pwd;

    private String phone;

    private AddressDto address;


    public static MysqlUserDto fromEntity(MysqlUserEntity user){
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

    public static MysqlUserEntity toEntity(MysqlUserDto user){
        if(user == null){
            return null;
        }
        return MysqlUserEntity.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birth(user.getBirth())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();
    }
}
