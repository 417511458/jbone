package cn.jbone.sys.common.dto.request;

import lombok.Data;

@Data
public class GithubUserLoginRequestDTO extends ThirdPartyUserLoginRequestDTO {
    private String login;
    private String nodeId;
    private String avatarUrl;
    private String htmlUrl;
    private String name;
    private String company;
    private String email;
    private String blog;

}
