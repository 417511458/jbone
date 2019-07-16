package cn.jbone.cms.common.dataobject;

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
     * 模版类型:企业宣传、个人博客、开源项目、政府官网、电子商务、bbs
     */
    private String type;

    /**
     * 风格：简约 / 唯美
     */
    private String style;

    /**
     * 色系：蓝色 / 红色 / 绿色 / 黄色
     */
    private String color;

    /**
     * 状态：1启用，0禁用
     */
    private int enable;

    private Integer creator;

    private int singlePage;

    /**
     * 数据收集器，以逗号隔开
     */
    private String dataCollectors;
}
