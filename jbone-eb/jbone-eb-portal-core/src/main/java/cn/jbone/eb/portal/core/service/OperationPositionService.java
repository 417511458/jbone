package cn.jbone.eb.portal.core.service;

import cn.jbone.common.api.dto.SearchListDTO;
import cn.jbone.common.exception.JboneException;
import cn.jbone.common.service.AbstractService;
import cn.jbone.eb.portal.api.dto.response.OperationPositionListByPageResponseDTO;
import cn.jbone.eb.portal.api.dto.response.OperationPositionRequestDTO;
import cn.jbone.eb.portal.api.dto.response.OperationPostionBaseInfoDTO;
import cn.jbone.eb.portal.core.dao.domain.OperationPositionEntity;
import cn.jbone.eb.portal.core.dao.repository.OperationPositionRepository;
import org.apache.commons.lang3.StringUtils;
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
     * @param searchListDTO 查询条件
     * @return
     */
    public OperationPositionListByPageResponseDTO findByPage(SearchListDTO searchListDTO){
        Page<OperationPositionEntity> page = operationPositionRepository.findAll(getSearchListSpecification(searchListDTO),getPageRequest(searchListDTO));
        OperationPositionListByPageResponseDTO responseDTO = new OperationPositionListByPageResponseDTO();
        responseDTO.setTotal(page.getTotalElements());
        responseDTO.setRows(entityToBos(page.getContent()));
        return responseDTO;
    }

    /**
     * 将实体类转换为业务类
     * @param list
     * @return
     */
    private List<OperationPostionBaseInfoDTO> entityToBos(List<OperationPositionEntity> list){
        List<OperationPostionBaseInfoDTO> dtos = new ArrayList<>();
        if(list != null && !list.isEmpty()){
            for (OperationPositionEntity entity:list){
                dtos.add(entityToBo(entity));
            }
        }
        return dtos;
    }

    /**
     * 将实体类转换为业务类
     * @param entity
     * @return
     */
    private OperationPostionBaseInfoDTO entityToBo(OperationPositionEntity entity){
        if(entity == null){
            return null;
        }
        OperationPostionBaseInfoDTO baseInfoDTO = new OperationPostionBaseInfoDTO();
        BeanUtils.copyProperties(entity,baseInfoDTO);
        return baseInfoDTO;
    }

    /**
     * 运营位保存
     * @param dto 运营位信息载体
     */
    public void save(OperationPositionRequestDTO dto){
        OperationPositionEntity entity = new OperationPositionEntity();
        BeanUtils.copyProperties(dto,entity);
        operationPositionRepository.save(entity);
    }

    /**
     * 根据id查询运营位详情
     * @param id
     * @return 单条运营位实体
     */
    public OperationPositionEntity findById(Integer id){
        OperationPositionEntity entity = operationPositionRepository.findOne(id);
        if(entity == null){
            throw new JboneException("没有找到运营位");
        }
        return entity;
    }

    /**
     * 删除运营位
     * @param ids
     */
    public void delete(String ids){
        String[] idArray =  ids.split(",");
        for (String id:idArray){
            if(StringUtils.isBlank(id)){
                continue;
            }
            operationPositionRepository.delete(Integer.parseInt(id));
        }
    }

    /**
     * 运营位更新
     * @param dto 运营位信息载体
     */
    public void update(OperationPositionRequestDTO dto) {
        OperationPositionEntity entity = operationPositionRepository.getOne(dto.getId());
        BeanUtils.copyProperties(dto,entity);
        operationPositionRepository.save(entity);
    }
}
