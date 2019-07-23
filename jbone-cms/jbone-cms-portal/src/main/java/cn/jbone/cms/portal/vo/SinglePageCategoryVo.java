package cn.jbone.cms.portal.vo;

import cn.jbone.cms.common.dataobject.ArticleDO;
import cn.jbone.cms.common.dataobject.ArticleResponseDO;
import lombok.Data;

import java.util.List;

@Data
public class SinglePageCategoryVo {
    private Long id;

    private String title;

    private List<ArticleResponseDO> articleList;
}
