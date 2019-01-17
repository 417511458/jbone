package cn.jbone.sys.common.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserSecurityQuestionsResponseDTO implements Serializable {
    private int userId;

    private String question;

    private String answer;
}
