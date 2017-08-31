package org.hhs.repositories;

import org.hhs.mapper.NoticeMapper;
import org.hhs.mapper.UserMapper;
import org.hhs.vo.Notice;
import org.hhs.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by hewater on 2017/8/30.
 */
@Repository
public class UserRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> findAll(){
        return jdbcTemplate.query("select * from user", new UserMapper());
    }
}
