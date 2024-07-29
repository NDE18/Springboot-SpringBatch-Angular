package com.nde.app.synchro.appSynchronisation.entities.mysqlentities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @CreatedDate
    @Column(name = "creationDate")
    private Instant creationDate=Instant.now();

    @LastModifiedDate
    @Column(name = "lastModifiedDate")
    private Instant lastModifiedDate = Instant.now();
}
