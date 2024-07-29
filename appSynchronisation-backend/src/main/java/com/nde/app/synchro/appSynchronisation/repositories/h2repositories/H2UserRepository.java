package com.nde.app.synchro.appSynchronisation.repositories.h2repositories;

import com.nde.app.synchro.appSynchronisation.entities.h2entities.H2UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface H2UserRepository extends JpaRepository<H2UserEntity, Integer> {

    Optional<H2UserEntity> findByEmail(String email);
}
