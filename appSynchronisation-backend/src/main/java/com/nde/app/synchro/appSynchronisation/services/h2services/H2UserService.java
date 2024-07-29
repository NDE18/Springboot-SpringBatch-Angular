package com.nde.app.synchro.appSynchronisation.services.h2services;



import com.nde.app.synchro.appSynchronisation.dto.h2dto.H2UserDto;

import java.util.List;

public interface H2UserService {

    H2UserDto save(H2UserDto userDto);

    H2UserDto findById(Integer id);

    H2UserDto findItemCode(String itemCode);

    List<H2UserDto> findAll();

    void delete(Integer id);
}
