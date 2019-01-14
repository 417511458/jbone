package cn.jbone.common.service.vo;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 查询列表model
 */
@Data
public class SearchListVo {

    private int pageSize;
    private int pageNumber;
    private Map<String,Object> condition = new HashMap<>();
    private String sortName;
    private String sortOrder;
}
