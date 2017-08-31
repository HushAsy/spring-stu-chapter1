package org.hhs.mapper;

import org.hhs.Adapter;
import org.hhs.vo.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hewater on 2017/8/30.
 */
public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
//        User user = new User();
//        user.setId(resultSet.getInt("id"));
//        user.setAvatar(resultSet.getString("avatar"));
//        user.setPassword(resultSet.get);

        return new Adapter<User>(resultSet, User.class).getObj();
    }
}
