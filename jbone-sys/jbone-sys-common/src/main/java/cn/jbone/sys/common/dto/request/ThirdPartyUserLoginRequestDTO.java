package cn.jbone.sys.common.dto.request;

import cn.jbone.sys.common.dto.ThirdPartyName;
import lombok.Data;

@Data
public class ThirdPartyUserLoginRequestDTO {
    private String id;

    private ThirdPartyName thirdPartyName;

}
