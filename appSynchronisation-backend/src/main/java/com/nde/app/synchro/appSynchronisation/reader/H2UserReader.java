package com.nde.app.synchro.appSynchronisation.reader;

import com.nde.app.synchro.appSynchronisation.dto.UserDto;
import com.nde.app.synchro.appSynchronisation.entities.h2entities.H2UserEntity;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class H2UserReader implements ItemReader<UserDto> {
    @Override
    public UserDto read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return null;
    }

    /*public H2UserReader(@Qualifier("sqliteDataSource") DataSource dataSource) {

        setSql("SELECT FROM _user");
        setFetchSize(100);
        setRowMapper(new ItemRowMapper());
    }*/

    /*public class ItemRowMapper implements RowMapper<UserDto> {
        @Override
        public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {

            H2UserEntity item  = new H2UserEntity();
            item.setId(rs.getInt("id"));
            item.setFirstName(rs.getString("firstname"));
            item.setLastName(rs.getString("lastname"));
            item.setBirth(rs.getString("birth"));
            item.setEmail(rs.getString("email"));
            item.setPhone(rs.getString("phone"));

            UserDto h2UserDto = UserDto.fromH2UserEntity(item);

            return h2UserDto;
        }
    }*/


}
