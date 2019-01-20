package cn.jbone.cms.common.module.article;

import cn.jbone.sys.common.dto.response.UserBaseInfoResponseDTO;
import lombok.Data;

@Data
public class ArticleResponseDO extends ArticleDO {
    private UserBaseInfoResponseDTO author;
}
