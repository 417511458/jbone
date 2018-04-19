package cn.jbone.bpm.api;

import cn.jbone.bpm.api.dto.request.QueryMyTaskRequestDTO;
import cn.jbone.bpm.api.dto.response.TaskInstanceResponseDTO;
import cn.jbone.common.rpc.Result;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/taskQuery")
public interface ProcessTaskQueryApi {
    @RequestMapping("/queryMyTask")
    Result<List<TaskInstanceResponseDTO>> queryMyTask(QueryMyTaskRequestDTO queryMyTaskRequestDTO);
}
