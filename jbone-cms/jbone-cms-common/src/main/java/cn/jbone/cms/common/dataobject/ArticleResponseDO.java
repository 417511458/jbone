package cn.jbone.cms.common.dataobject;

import cn.jbone.sys.common.UserResponseDO;
import lombok.Data;

@Data
public class ArticleResponseDO extends ArticleDO {
    private UserResponseDO author;
}
