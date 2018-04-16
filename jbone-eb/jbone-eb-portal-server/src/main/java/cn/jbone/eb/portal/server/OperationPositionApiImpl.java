package cn.jbone.eb.portal.server;

import cn.jbone.common.api.dto.SearchListDTO;
import cn.jbone.common.rpc.Result;
import cn.jbone.eb.portal.api.OperationPositionApi;
import cn.jbone.eb.portal.api.dto.response.OperationPositionListByPageResponseDTO;
import cn.jbone.eb.portal.api.dto.response.OperationPositionRequestDTO;
import cn.jbone.eb.portal.core.dao.domain.OperationPositionEntity;
import cn.jbone.eb.portal.core.service.OperationPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/operationPosition")
public class OperationPositionApiImpl implements OperationPositionApi {
    @Autowired
    private OperationPositionService operationPositionService;
    @Override
    @RequestMapping(value = "/findByPage", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<OperationPositionListByPageResponseDTO> findByPage(@RequestBody SearchListDTO searchListDTO) {
        OperationPositionListByPageResponseDTO responseDTO = operationPositionService.findByPage(searchListDTO);
        return new Result<OperationPositionListByPageResponseDTO>(responseDTO);
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody OperationPositionRequestDTO dto) {
        operationPositionService.save(dto);
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody OperationPositionRequestDTO dto) {
        operationPositionService.update(dto);
    }

    @Override
    @RequestMapping(value = "/findById", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public OperationPositionRequestDTO findById(@RequestBody Integer id) {
        OperationPositionRequestDTO dto = new OperationPositionRequestDTO();
        OperationPositionEntity operationPositionEntity = operationPositionService.findById(id);
        BeanUtils.copyProperties(operationPositionEntity,dto);
        return dto;
    }

    @Override
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@RequestBody String ids) {
        operationPositionService.delete(ids);
    }
}
