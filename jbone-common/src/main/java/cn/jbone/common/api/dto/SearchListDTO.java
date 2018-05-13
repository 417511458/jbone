package cn.jbone.common.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 查询列表model
 */
@Data
public class SearchListDTO implements Serializable {

    private int pageSize;
    private int pageNumber;
    private Map<String,Object> condition = new HashMap<>();
    private String sortName;
    private String sortOrder;
}
