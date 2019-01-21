package cn.jbone.sys.common;

import lombok.Data;

@Data
public class UserSecurityInfoDO {
    private String password;
    private int locked;
    private String salt;
}
