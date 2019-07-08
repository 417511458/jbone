package cn.jbone.cms.common.dataobject.search;

import cn.jbone.common.dataobject.SearchListDO;
import lombok.Data;

@Data
public class TemplateSearchDO extends SearchListDO {

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
    private int enable = -1;
}
