package com.nde.app.synchro.appSynchronisation.services.mysqlservices;



import com.nde.app.synchro.appSynchronisation.dto.mysqldto.MysqlUserDto;

import java.util.List;

public interface MysqlUserService {

    MysqlUserDto save(MysqlUserDto userDto);

    MysqlUserDto findById(Integer id);

    MysqlUserDto findItemCode(String itemCode);

    List<MysqlUserDto> findAll();

    void delete(Integer id);
}
