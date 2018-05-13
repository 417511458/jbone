package cn.jbone.eb.manager.core.service.vo.operation;

import lombok.Data;

import java.util.List;

@Data
public class OperationPositionListVo {
    private long total;
    private List<OperationBaseInfoVo> rows;
}
