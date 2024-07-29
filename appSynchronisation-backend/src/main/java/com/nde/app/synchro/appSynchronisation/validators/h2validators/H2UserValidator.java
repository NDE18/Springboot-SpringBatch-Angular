package com.nde.app.synchro.appSynchronisation.validators.h2validators;

import com.nde.app.synchro.appSynchronisation.dto.h2dto.H2UserDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class H2UserValidator {

    public static List<String> validate(H2UserDto userDto){
        List<String> errors = new ArrayList<>();

        if(userDto == null){
            errors.add("Please enter lastname");
            errors.add("Please enter firstname");
            errors.add("Please enter email");
            return errors;
        }

        if(!StringUtils.hasLength(userDto.getLastName())){
            errors.add("Please enter lastname");
        }
        if(!StringUtils.hasLength(userDto.getFirstName())){
            errors.add("Please enter firstname");
        }
        if(!StringUtils.hasLength(userDto.getEmail())){
            errors.add("Please enter email");
        }
        if(userDto.getBirth() == null){
            errors.add("Please enter birthdate");
        }
        return errors;
    }
}
