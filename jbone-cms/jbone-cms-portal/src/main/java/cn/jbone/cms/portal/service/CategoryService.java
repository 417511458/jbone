package cn.jbone.cms.portal.service;

import cn.jbone.cms.api.CategoryApi;
import cn.jbone.cms.api.CategoryTocApi;
import cn.jbone.cms.common.dataobject.CategoryDO;
import cn.jbone.cms.common.dataobject.search.CategorySearchDO;
import cn.jbone.cms.common.dataobject.CategoryTocDO;
import cn.jbone.cms.common.enums.BooleanEnum;
import cn.jbone.cms.common.enums.StatusEnum;
import cn.jbone.common.rpc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryApi categoryApi;
    @Autowired
    private CategoryTocApi categoryTocApi;

    public CategoryDO findById(Long id){
        Result<CategoryDO> result = categoryApi.get(id);
        if(result != null && result.isSuccess()){
            CategoryDO categoryDO = result.getData();
            if(categoryDO != null){
                categoryDO.setChildren(getChildren(id));
            }
            return categoryDO;
        }
        return null;
    }

    public List<CategoryDO> getChildren(Long pid){
        CategorySearchDO categorySearchDO = new CategorySearchDO();
        categorySearchDO.setStatus(StatusEnum.PUBLISH);
        categorySearchDO.setInMenu(BooleanEnum.TRUE);
        categorySearchDO.setPid(pid);
        Result<List<CategoryDO>> result =  categoryApi.requestCategorysTree(categorySearchDO);
        if(result != null && result.isSuccess()){
            return result.getData();
        }
        return null;
    }

    public List<CategoryTocDO> getCategoryTocTree(Long categoryId){
        Result<List<CategoryTocDO>> result = categoryTocApi.getTree(categoryId);
        if(result != null && result.isSuccess()){
            return result.getData();
        }
        return null;
    }

    public CategoryTocDO getTocById(Long id){
        Result<CategoryTocDO> result = categoryTocApi.get(id);
        if(result != null && result.isSuccess()){
            return result.getData();
        }
        return null;
    }
}
