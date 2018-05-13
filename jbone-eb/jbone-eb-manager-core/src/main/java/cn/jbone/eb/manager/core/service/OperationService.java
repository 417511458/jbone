package cn.jbone.eb.manager.core.service;

import cn.jbone.common.rpc.Result;
import cn.jbone.common.service.vo.SearchListVo;
import cn.jbone.common.utils.VoDtoUtils;
import cn.jbone.eb.manager.core.service.vo.operation.CreateOperationVo;
import cn.jbone.eb.manager.core.service.vo.operation.OperationBaseInfoVo;
import cn.jbone.eb.manager.core.service.vo.operation.OperationPositionListVo;
import cn.jbone.eb.manager.core.service.vo.operation.UpdateOperationVo;
import cn.jbone.eb.portal.api.OperationPositionApi;
import cn.jbone.eb.portal.api.dto.response.OperationPositionListByPageResponseDTO;
import cn.jbone.eb.portal.api.dto.response.OperationPositionRequestDTO;
import cn.jbone.eb.portal.api.dto.response.OperationPositionResponceDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationService {

    @Autowired
    private OperationPositionApi operationPositionApi;

    public OperationPositionListVo findByPage(SearchListVo searchListVo) {
        Result<OperationPositionListByPageResponseDTO> result = operationPositionApi.findByPage(VoDtoUtils.searchListVoToDTO(searchListVo));
        if (result != null && result.isSuccess()) {
            OperationPositionListByPageResponseDTO responseDTO = result.getData();
            OperationPositionListVo listVo = new OperationPositionListVo();
            BeanUtils.copyProperties(responseDTO, listVo);
            return listVo;
        }
        return null;
    }

    public void create(CreateOperationVo createOperationVo) {
        OperationPositionRequestDTO dto = new OperationPositionRequestDTO();
        BeanUtils.copyProperties(createOperationVo, dto);
        operationPositionApi.save(dto);
    }

    public void update(UpdateOperationVo updateOperationVo) {
        OperationPositionRequestDTO dto = new OperationPositionRequestDTO();
        BeanUtils.copyProperties(updateOperationVo, dto);
        operationPositionApi.update(dto);
    }

    public void delete(String ids) {
        operationPositionApi.delete(ids);
    }

    public OperationBaseInfoVo get(Integer id) {
        Result<OperationPositionResponceDTO> result = operationPositionApi.findById(id);
        if (result != null && result.isSuccess()) {
            OperationPositionResponceDTO responseDTO = result.getData();
            OperationBaseInfoVo listVo = new OperationBaseInfoVo();
            BeanUtils.copyProperties(responseDTO, listVo);
            return listVo;
        }
        return null;
    }

}
