package cn.jbone.eb.manager.core.service;

import cn.jbone.common.service.bo.SearchListBO;
import cn.jbone.common.ui.result.ListResult;
import cn.jbone.common.ui.result.Result;
import cn.jbone.common.utils.BoDtoUtils;
import cn.jbone.common.utils.ResultUtils;
import cn.jbone.eb.manager.core.service.bo.operation.CreateOperationBO;
import cn.jbone.eb.manager.core.service.bo.operation.UpdateOperationBO;
import cn.jbone.eb.portal.api.OperationPositionApi;
import cn.jbone.eb.portal.api.dto.response.OperationPositionListByPageResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationService {

    @Autowired
    private OperationPositionApi operationPositionApi;

    public ListResult findByPage(SearchListBO searchListBO){
        cn.jbone.common.rpc.Result<OperationPositionListByPageResponseDTO> result = operationPositionApi.findByPage(BoDtoUtils.searchListBoToDTO(searchListBO));
        if(result != null && result.isSuccess()){
            OperationPositionListByPageResponseDTO responseDTO = result.getData();
            return ResultUtils.wrapSuccess(responseDTO.getTotal(),responseDTO.getRows());
        }
        return ResultUtils.wrapListFail("获取数据失败");
    }

    public Result create(CreateOperationBO createOperationBO){
        return ResultUtils.wrapSuccess();
    }

    public Result update(UpdateOperationBO updateOperationBO){
        return ResultUtils.wrapSuccess();
    }

    public Result delete(String ids){
        return ResultUtils.wrapSuccess();
    }

    public Result get(int id){
        return ResultUtils.wrapSuccess();
    }

}
