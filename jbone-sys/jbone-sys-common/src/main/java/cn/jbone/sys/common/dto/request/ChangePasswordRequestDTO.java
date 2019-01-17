package cn.jbone.sys.common.dto.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChangePasswordRequestDTO implements Serializable {
    private String password;

    private String confirmedPassword;

    private String username;
}
