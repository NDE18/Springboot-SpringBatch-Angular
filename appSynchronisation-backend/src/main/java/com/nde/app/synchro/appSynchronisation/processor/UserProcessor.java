package com.nde.app.synchro.appSynchronisation.processor;

import com.nde.app.synchro.appSynchronisation.dto.UserDto;
import com.nde.app.synchro.appSynchronisation.dto.h2dto.H2UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserProcessor implements ItemProcessor<UserDto, UserDto> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserProcessor.class);

    @Override
    public UserDto process(UserDto item) throws Exception {

        LOGGER.info("Processing Record: {}", item);
        return item;
    }
}
