package cn.jbone.eb.portal.api;


import cn.jbone.common.api.dto.SearchListDTO;
import cn.jbone.common.rpc.Result;
import cn.jbone.eb.portal.api.dto.response.OperationPositionListByPageResponseDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/operationPosition")
public interface OperationPositionApi {
    @RequestMapping(value = "/findByPage", method = RequestMethod.POST)
    Result<OperationPositionListByPageResponseDTO> findByPage(@RequestBody SearchListDTO searchListDTO);
}
