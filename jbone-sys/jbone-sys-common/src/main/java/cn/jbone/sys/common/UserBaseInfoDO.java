package cn.jbone.sys.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserBaseInfoDO implements Serializable {
    private int id;
    private String username;
    private String realname;
    private String avatar;
    private String phone;
    private String email;
    private int sex;
}
