package cn.jbone.cms.portal.service;

import cn.jbone.cms.api.CategoryApi;
import cn.jbone.cms.api.TagApi;
import cn.jbone.cms.common.dataobject.CategoryDO;
import cn.jbone.cms.common.dataobject.TagDO;
import cn.jbone.common.rpc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryApi categoryApi;

    public CategoryDO findById(Long id){
        Result<CategoryDO> result = categoryApi.get(id);
        if(result != null && result.isSuccess()){
            return result.getData();
        }
        return null;
    }
}
