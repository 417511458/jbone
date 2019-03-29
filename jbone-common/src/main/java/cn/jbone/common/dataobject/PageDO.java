package cn.jbone.common.dataobject;

import lombok.Data;

/**
 * 分页组件中的页码
 */
@Data
public class PageDO {
    private int pageNum;    //页码
    private String text;    //文本
}
