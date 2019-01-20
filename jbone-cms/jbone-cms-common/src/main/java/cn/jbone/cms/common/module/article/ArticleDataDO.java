package cn.jbone.cms.common.module.article;

import lombok.Data;

@Data
public class ArticleDataDO {

    /**
     * 内容
     */
    private String content;

    /**
     * 文章目录
     */
    private String tableOfContents;
}
