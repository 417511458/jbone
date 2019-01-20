package cn.jbone.cms.common.module.article;

import cn.jbone.cms.common.enums.TemplateTypeEnum;
import lombok.Data;

@Data
public class TemplateDO {

    private Long id;

    /**
     * 标题
     */
    private String name;

    /**
     * 模版编码，对应于前端的模版目录
     */
    private String code;

    /**
     * 封面图
     */
    private String frontCover;

    /**
     * 图片
     */
    private String images;

    /**
     * 描述，摘要
     */
    private String description;

    /**
     * 模版类型
     */
    private TemplateTypeEnum type;
}
