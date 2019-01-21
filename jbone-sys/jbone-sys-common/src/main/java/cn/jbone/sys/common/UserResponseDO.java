package cn.jbone.sys.common;

import lombok.Data;

@Data
public class UserResponseDO {
    private UserBaseInfoDO baseInfo;        //基本信息
    private UserAuthInfoDO authInfo;        //权限信息
    private UserSecurityInfoDO securityInfo; //密码安全信息
}
