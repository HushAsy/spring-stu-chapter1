package org.hhs.vo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * Created by hewater on 2017/8/29.
 */
@Data
@ToString
public class Notice {
    private int id;
    private String title;
    private int type;
    private String content;
    private Date createTime;
    private int creater;
}
