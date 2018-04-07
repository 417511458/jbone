package cn.jbone.eb.portal.core.service;

import cn.jbone.common.service.AbstractService;
import cn.jbone.common.service.bo.SearchListBO;
import cn.jbone.common.ui.result.ListResult;
import cn.jbone.common.utils.ResultUtils;
import cn.jbone.eb.portal.core.dao.domain.OperationPositionEntity;
import cn.jbone.eb.portal.core.dao.repository.OperationPositionRepository;
import cn.jbone.eb.portal.core.service.bo.operationposition.OperationPostionBaseInfoBO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OperationPositionService extends AbstractService<OperationPositionEntity> {

    @Autowired
    private OperationPositionRepository operationPositionRepository;

    /**
     * 分页查询
     * @param searchListBO 查询条件
     * @return
     */
    public ListResult findByPage(SearchListBO searchListBO){
        Page<OperationPositionEntity> page = operationPositionRepository.findAll(getSearchListSpecification(searchListBO),getPageRequest(searchListBO));
        return ResultUtils.wrapSuccess(page.getTotalElements(),entityToBos(page.getContent()));
    }

    /**
     * 将实体类转换为业务类
     * @param list
     * @return
     */
    private List<OperationPostionBaseInfoBO> entityToBos(List<OperationPositionEntity> list){
        List<OperationPostionBaseInfoBO> operationPostionBaseInfoBOList = new ArrayList<>();
        if(list != null && !list.isEmpty()){
            for (OperationPositionEntity entity:list){
                operationPostionBaseInfoBOList.add(entityToBo(entity));
            }
        }
        return operationPostionBaseInfoBOList;
    }

    /**
     * 将实体类转换为业务类
     * @param entity
     * @return
     */
    private OperationPostionBaseInfoBO entityToBo(OperationPositionEntity entity){
        if(entity == null){
            return null;
        }
        OperationPostionBaseInfoBO baseInfoBO = new OperationPostionBaseInfoBO();
        BeanUtils.copyProperties(entity,baseInfoBO);
        return baseInfoBO;
    }
}
