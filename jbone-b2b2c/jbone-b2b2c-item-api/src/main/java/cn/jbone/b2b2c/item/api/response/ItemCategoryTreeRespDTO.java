package cn.jbone.b2b2c.item.api.response;

import lombok.Data;

import java.util.List;

@Data
public class ItemCategoryTreeRespDTO {
    private long id;
    private String name;
    private List<ItemCategoryTreeRespDTO> children;
}
