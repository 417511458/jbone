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
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationService {

    @Autowired
    private OperationPositionApi operationPositionApi;

    public OperationPositionListVo findByPage(SearchListVo searchListVo){
        Result<OperationPositionListByPageResponseDTO> result = operationPositionApi.findByPage(VoDtoUtils.searchListVoToDTO(searchListVo));
        if(result != null && result.isSuccess()){
            OperationPositionListByPageResponseDTO responseDTO = result.getData();
            OperationPositionListVo listVo = new OperationPositionListVo();
            BeanUtils.copyProperties(responseDTO,listVo);
            return listVo;
        }
        return null;
    }



    public void create(CreateOperationVo createOperationVo){

    }

    public void update(UpdateOperationVo updateOperationVo){

    }

    public void delete(String ids){

    }

    public OperationBaseInfoVo get(int id){
        return null;
    }

}
