package cn.jbone.eb.portal.server;

import cn.jbone.common.api.dto.SearchListDTO;
import cn.jbone.common.rpc.Result;
import cn.jbone.common.service.bo.SearchListBO;
import cn.jbone.common.ui.result.ListResult;
import cn.jbone.eb.portal.api.OperationPositionApi;
import cn.jbone.eb.portal.api.dto.response.OperationPositionListByPageResponseDTO;
import cn.jbone.eb.portal.api.dto.response.OperationPostionBaseInfoDTO;
import cn.jbone.eb.portal.core.service.OperationPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/operationPosition")
public class OperationPositionApiImpl implements OperationPositionApi {
    @Autowired
    private OperationPositionService operationPositionService;
    @Override
    @RequestMapping(value = "/findByPage", method = RequestMethod.POST)
    public Result<OperationPositionListByPageResponseDTO> findByPage(@RequestBody SearchListDTO searchListDTO) {
        SearchListBO searchListBO = new SearchListBO();
        BeanUtils.copyProperties(searchListDTO,searchListBO);
        ListResult result = operationPositionService.findByPage(searchListBO);
        OperationPositionListByPageResponseDTO responseDTO = new OperationPositionListByPageResponseDTO();
        responseDTO.setRows((List<OperationPostionBaseInfoDTO>)result.getRows());
        responseDTO.setTotal(result.getTotal());
        return new Result<OperationPositionListByPageResponseDTO>(responseDTO);
    }
}
