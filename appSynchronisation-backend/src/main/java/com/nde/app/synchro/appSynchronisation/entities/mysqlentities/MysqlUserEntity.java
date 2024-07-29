package com.nde.app.synchro.appSynchronisation.entities.mysqlentities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class MysqlUserEntity {

    @Id
    private Integer id;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "birth")
    private String birth;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

}
