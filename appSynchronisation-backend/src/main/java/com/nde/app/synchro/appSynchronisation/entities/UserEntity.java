package com.nde.app.synchro.appSynchronisation.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserEntity {

    private Integer id;

    private String lastName;

    private String firstName;

    private String birth;

    private String email;

    private String phone;
}
