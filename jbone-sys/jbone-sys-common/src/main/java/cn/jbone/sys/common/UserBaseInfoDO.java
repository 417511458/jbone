package cn.jbone.sys.common;

import lombok.Data;

@Data
public class UserBaseInfoDO {
    private int id;
    private String username;
    private String realname;
    private String avatar;
    private String phone;
    private String email;
    private int sex;
}
