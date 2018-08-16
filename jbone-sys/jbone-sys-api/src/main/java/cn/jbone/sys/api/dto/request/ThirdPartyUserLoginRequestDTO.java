package cn.jbone.sys.api.dto.request;

import cn.jbone.sys.api.dto.ThirdPartyName;
import lombok.Data;

@Data
public class ThirdPartyUserLoginRequestDTO {
    private String id;

    private ThirdPartyName thirdPartyName;

}
