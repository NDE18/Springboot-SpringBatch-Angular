package com.nde.app.synchro.appSynchronisation.services.mysqlservices.impl;

import com.nde.app.synchro.appSynchronisation.dto.mysqldto.MysqlUserDto;
import com.nde.app.synchro.appSynchronisation.exceptions.EntityNotFoundException;
import com.nde.app.synchro.appSynchronisation.exceptions.ErrorCodes;
import com.nde.app.synchro.appSynchronisation.exceptions.InvalidEntityException;
import com.nde.app.synchro.appSynchronisation.entities.mysqlentities.MysqlUserEntity;
import com.nde.app.synchro.appSynchronisation.repositories.mysqlrepositories.MysqlUserRepository;
import com.nde.app.synchro.appSynchronisation.services.mysqlservices.MysqlUserService;
import com.nde.app.synchro.appSynchronisation.validators.mysqlvalidators.MysqlUserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MysqlUserServiceImpl implements MysqlUserService {

    private MysqlUserRepository mysqlUserRepository;

    public MysqlUserServiceImpl(MysqlUserRepository userRepository){
        this.mysqlUserRepository = userRepository;
    }

    @Override
    public MysqlUserDto save(MysqlUserDto userDto) {
        List<String> errors = MysqlUserValidator.validate(userDto);
        if(!errors.isEmpty()){
            log.error("User is not valid {}", userDto);
            throw new InvalidEntityException("User is not valid", ErrorCodes.USER_NOT_FOUND, errors);
        }
        return MysqlUserDto.fromEntity(mysqlUserRepository.save(MysqlUserDto.toEntity(userDto)));
    }

    @Override
    public MysqlUserDto findById(Integer id) {
        if(id == null){
            log.error("ID user is null {}", id);
            return null;
        }
        Optional<MysqlUserEntity> user = mysqlUserRepository.findById(id);

        MysqlUserDto userDto = MysqlUserDto.fromEntity(user.get());
        return Optional.of(userDto).orElseThrow(() -> new EntityNotFoundException(
                "No user with ID = "+id+" found.",
                ErrorCodes.USER_NOT_FOUND
        ));
    }

    @Override
    public MysqlUserDto findItemCode(String itemCode) {
        return null;
    }

    @Override
    public List<MysqlUserDto> findAll() {
        return mysqlUserRepository.findAll()
                .stream().map(MysqlUserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            return;
        }
        mysqlUserRepository.deleteById(id);
    }
}
