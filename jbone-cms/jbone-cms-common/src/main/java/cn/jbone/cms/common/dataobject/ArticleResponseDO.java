package cn.jbone.cms.common.dataobject;

import cn.jbone.system.common.UserResponseDO;
import lombok.Data;
@Data
public class ArticleResponseDO extends ArticleDO {
    private UserResponseDO author;
}
