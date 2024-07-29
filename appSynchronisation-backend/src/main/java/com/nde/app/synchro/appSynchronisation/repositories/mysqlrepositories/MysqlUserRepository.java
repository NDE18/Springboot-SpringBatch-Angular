package com.nde.app.synchro.appSynchronisation.repositories.mysqlrepositories;

import com.nde.app.synchro.appSynchronisation.entities.mysqlentities.MysqlUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MysqlUserRepository extends JpaRepository<MysqlUserEntity, Integer> {

    Optional<MysqlUserEntity> findByEmail(String email);
}
