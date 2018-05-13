package cn.jbone.eb.portal.api.dto.request;

import lombok.Data;

@Data
public class ListRequestDTO {
    private int pageSize;
    private int pageNumber;
    private String searchText;
    private String sortName;
    private String sortOrder;
}
