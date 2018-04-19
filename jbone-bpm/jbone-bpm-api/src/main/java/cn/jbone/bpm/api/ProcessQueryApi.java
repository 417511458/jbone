package cn.jbone.bpm.api;

import cn.jbone.bpm.api.dto.response.ProcessInstanceQueryRequestDTO;
import cn.jbone.bpm.api.dto.response.ProcessInstanceQueryResponseDTO;
import cn.jbone.common.rpc.Result;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/processQuery")
public interface ProcessQueryApi {

    /**
     * 查询流程实例
     * @param processInstanceQueryRequestDTO 查询流程实例DTO
     * @return
     */
    @RequestMapping("/queryProcessInstance")
    Result<ProcessInstanceQueryResponseDTO> queryProcessInstance(ProcessInstanceQueryRequestDTO processInstanceQueryRequestDTO);
}
