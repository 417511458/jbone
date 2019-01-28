package cn.jbone.cms.common.dataobject;

import lombok.Data;

import java.util.List;

@Data
public class PagedResponseDO<T> {
    long total;
    int pageSize;
    int pageNum;
    List<T> datas;
}
