package cn.jbone.common.dataobject;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查询列表条件
 */
@Data
public class SearchListDO implements Serializable {

    private int pageSize = 10;
    private int pageNumber = 1;
    private List<SearchConditionDO> conditions = new ArrayList<>();
    private List<SearchSortDO> sorts = new ArrayList<>();

    public void addCondition(SearchConditionDO searchConditionDO){
        this.conditions.add(searchConditionDO);
    }

    public void addSort(SearchSortDO searchSortDO){
        this.sorts.add(searchSortDO);
    }

    public void clearSort(){
        this.sorts.clear();
    }

    public void setSort(SearchSortDO searchSortDO){
        this.clearSort();
        this.addSort(searchSortDO);
    }

}
