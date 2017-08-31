package org.hhs.repositories;

import org.hhs.mapper.NoticeMapper;
import org.hhs.vo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hewater on 2017/8/29.
 */
@Repository
public class NoticeRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Notice> findAll(){
        return jdbcTemplate.query("select * from notice", new NoticeMapper());
    }
}
