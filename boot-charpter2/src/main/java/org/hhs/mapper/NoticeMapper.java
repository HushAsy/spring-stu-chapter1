package org.hhs.mapper;

import org.hhs.Adapter;
import org.hhs.vo.Notice;
import org.hhs.vo.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hewater on 2017/8/29.
 */
public class NoticeMapper implements RowMapper<Notice> {
    @Override
    public Notice mapRow(ResultSet resultSet, int i) throws SQLException {
//        Notice notice = new Notice();
//        notice.setContent(resultSet.getString("content"));
//        notice.setCreater(resultSet.getInt("creater"));
//        notice.setTitle(resultSet.getString("title"));
//        notice.setType(resultSet.getInt("type"));
//        notice.setCreateTime(resultSet.getDate("createtime"));
        return new Adapter<Notice>(resultSet, Notice.class).getObj();
    }
}
