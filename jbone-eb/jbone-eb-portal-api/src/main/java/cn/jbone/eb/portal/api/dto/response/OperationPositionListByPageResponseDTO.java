package cn.jbone.eb.portal.api.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class OperationPositionListByPageResponseDTO {
    private long total;
    private List<OperationPostionBaseInfoDTO> rows;
}
