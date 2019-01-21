package cn.jbone.cms.common.module.article;

import cn.jbone.sys.common.UserBaseInfoDO;
import cn.jbone.sys.common.UserResponseDO;
import cn.jbone.sys.common.dto.response.UserBaseInfoResponseDTO;
import lombok.Data;

@Data
public class ArticleResponseDO extends ArticleDO {
    private UserResponseDO author;
}
