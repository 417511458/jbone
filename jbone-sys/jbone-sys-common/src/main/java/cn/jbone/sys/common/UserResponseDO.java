package cn.jbone.sys.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserResponseDO implements Serializable {
    private UserBaseInfoDO baseInfo;        //基本信息
    private UserAuthInfoDO authInfo;        //权限信息
    private UserSecurityInfoDO securityInfo; //密码安全信息
}
