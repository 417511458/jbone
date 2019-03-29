package cn.jbone.common.dataobject;

import lombok.Data;

import java.util.List;

/**
 * 分页组件
 */
@Data
public class PaginationDO {
    private boolean showLastButton;     //是否展示上一页
    private boolean showNextButton;     //是否展示下一页
    private int lastPage;               //上一页
    private int nextPage;               //下一页

    private List<PageDO> pages;         //中间页码

}
