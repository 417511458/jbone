package cn.jbone.cms.common.dataobject;

import lombok.Data;

import java.util.List;

@Data
public class ArticleCommonResponseDO {

    List<ArticleResponseDO> articles;
    long total;
    int pageSize;
    int pageNum;
}
