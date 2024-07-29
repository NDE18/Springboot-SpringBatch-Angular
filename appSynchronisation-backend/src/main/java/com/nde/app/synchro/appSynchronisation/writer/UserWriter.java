package com.nde.app.synchro.appSynchronisation.writer;

import com.nde.app.synchro.appSynchronisation.dto.UserDto;
import com.nde.app.synchro.appSynchronisation.dto.mysqldto.MysqlUserDto;
import com.nde.app.synchro.appSynchronisation.entities.h2entities.H2UserEntity;
import com.nde.app.synchro.appSynchronisation.entities.mysqlentities.MysqlUserEntity;
import com.nde.app.synchro.appSynchronisation.repositories.mysqlrepositories.MysqlUserRepository;
import jakarta.persistence.Access;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("UserWriter")
public class UserWriter implements ItemWriter<UserDto> {

    @Autowired
    MysqlUserRepository mysqlUserRepository;

    @Override
    public void write(Chunk<? extends UserDto> chunk) throws Exception {

        for (UserDto data: chunk){
            MysqlUserEntity mysqlUserDto = UserDto.toMysqlUserEntity(data);
            mysqlUserRepository.save(mysqlUserDto);

        }
    }
}
