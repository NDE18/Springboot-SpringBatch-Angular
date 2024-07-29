package com.nde.app.synchro.appSynchronisation.controllers;

import com.nde.app.synchro.appSynchronisation.controllers.api.UserApi;
import com.nde.app.synchro.appSynchronisation.dto.UserDto;
import com.nde.app.synchro.appSynchronisation.dto.mysqldto.MysqlUserDto;
import com.nde.app.synchro.appSynchronisation.dto.h2dto.H2UserDto;
import com.nde.app.synchro.appSynchronisation.services.mysqlservices.MysqlUserService;
import com.nde.app.synchro.appSynchronisation.services.h2services.H2UserService;
import com.nde.app.synchro.appSynchronisation.utils.CheckConnectionAccess;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@Tag(
        name = "User Controller All CRUD API",
        description = "This class implements all the CRUD api related for user management"
)
public class UserController implements UserApi {

    private MysqlUserService userService;
    private H2UserService h2UserService;

    @Autowired
    public UserController(MysqlUserService userService, H2UserService h2UserService) {
        this.userService = userService;
        this.h2UserService = h2UserService;
    }

    @Override
    public ResponseEntity save(UserDto userDto) {
        if(CheckConnectionAccess.netIsAvailable()) {

            MysqlUserDto mysqlUserDto = UserDto.toMysqlUserDto(userDto);
            return ResponseEntity.ok(userService.save(mysqlUserDto));
        }
        else {
            H2UserDto sqliteUserDto = UserDto.toSqliteUserDto(userDto);

            return ResponseEntity.ok(h2UserService.save(sqliteUserDto));
        }
    }

    @Override
    public ResponseEntity<MysqlUserDto> findById(Integer id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @Override
    public ResponseEntity<MysqlUserDto> findUserCode(String userCode) {
        return null;
    }

    @Override
    public ResponseEntity<List<?>> findAll() {
        if(CheckConnectionAccess.netIsAvailable()) {
            return ResponseEntity.ok(userService.findAll());
        }
        else {
            return ResponseEntity.ok(h2UserService.findAll());
        }
    }

    @Override
    public ResponseEntity delete(Integer id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
