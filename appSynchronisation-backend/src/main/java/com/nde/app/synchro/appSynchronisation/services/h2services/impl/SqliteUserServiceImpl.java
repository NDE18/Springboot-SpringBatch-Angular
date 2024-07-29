package com.nde.app.synchro.appSynchronisation.services.h2services.impl;

import com.nde.app.synchro.appSynchronisation.dto.h2dto.H2UserDto;
import com.nde.app.synchro.appSynchronisation.exceptions.EntityNotFoundException;
import com.nde.app.synchro.appSynchronisation.exceptions.ErrorCodes;
import com.nde.app.synchro.appSynchronisation.exceptions.InvalidEntityException;
import com.nde.app.synchro.appSynchronisation.services.h2services.H2UserService;
import com.nde.app.synchro.appSynchronisation.entities.h2entities.H2UserEntity;
import com.nde.app.synchro.appSynchronisation.repositories.h2repositories.H2UserRepository;
import com.nde.app.synchro.appSynchronisation.validators.h2validators.H2UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SqliteUserServiceImpl implements H2UserService {

    private H2UserRepository userRepository;


    public SqliteUserServiceImpl(H2UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public H2UserDto save(H2UserDto userDto) {
        List<String> errors = H2UserValidator.validate(userDto);
        if(!errors.isEmpty()){
            log.error("User is not valid {}", userDto);
            throw new InvalidEntityException("User is not valid", ErrorCodes.USER_NOT_FOUND, errors);
        }
        return H2UserDto.fromEntity(userRepository.save(H2UserDto.toEntity(userDto)));
    }

    @Override
    public H2UserDto findById(Integer id) {
        if(id == null){
            log.error("ID user is null {}", id);
            return null;
        }
        Optional<H2UserEntity> user = userRepository.findById(id);

        H2UserDto userDto = H2UserDto.fromEntity(user.get());
        return Optional.of(userDto).orElseThrow(() -> new EntityNotFoundException(
                "No user with ID = "+id+" found.",
                ErrorCodes.USER_NOT_FOUND
        ));
    }

    @Override
    public H2UserDto findItemCode(String itemCode) {
        return null;
    }

    @Override
    public List<H2UserDto> findAll() {
        return userRepository.findAll().stream().map(H2UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            return;
        }
        userRepository.deleteById(id);
    }
}
