package cn.jbone.common.dataobject;

import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页数据对象
 */
@Data
public class PagedResponseDO<T> {
    long total;
    int pageSize;
    int pageNum;
    List<T> datas;

    PaginationDO pagination;    //分页组建

    public T getFirstData(){
        if(CollectionUtils.isEmpty(this.datas)){
            return null;
        }
        return this.datas.get(0);
    }

    public void buildPagination(){
        if(total <= 0){
            return;
        }
        this.pagination = new PaginationDO();

        this.pagination.setLastPage(pageNum - 1);
        this.pagination.setNextPage(pageNum + 1);

        if(pageNum == 1){
            this.pagination.setShowLastButton(false);
        }else{
            this.pagination.setShowLastButton(true);
        }

        int totalPage = (int) ((total % pageSize > 0) ? (total / pageSize + 1) : (total / pageSize));
        if(pageNum >= totalPage){
            this.pagination.setShowNextButton(false);
        }else{
            this.pagination.setShowNextButton(true);
        }

        //构建中间页码列表
        List<PageDO> pageDOS = new ArrayList<>();
        if(totalPage <= 5 && totalPage > 1){
            for (int i = 0;i < totalPage;i++){
                PageDO pageDO = new PageDO();
                pageDO.setPageNum(i+1);
                pageDO.setText(i+1 + "");
                pageDOS.add(pageDO);
            }
        }else{
            //大于5页，只展示前后两个页码
            int maxPage = Math.min(pageNum + 2,totalPage) ;
            int minPage = Math.max(pageNum - 2,1);
            for (int i = minPage;i <= maxPage;i++){
                PageDO pageDO = new PageDO();
                pageDO.setPageNum(i);
                pageDO.setText(i + "");
                pageDOS.add(pageDO);
            }
        }
        pagination.setPages(pageDOS);
    }
}
