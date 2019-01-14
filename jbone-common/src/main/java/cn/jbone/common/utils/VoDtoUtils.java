package cn.jbone.common.utils;

import cn.jbone.common.api.dto.SearchListDTO;
import cn.jbone.common.service.vo.SearchListVo;
import org.springframework.beans.BeanUtils;

public class VoDtoUtils {
    public static SearchListVo searchListDTOToVo(SearchListDTO dto){
        if(dto == null){
            return null;
        }
        SearchListVo bo = new SearchListVo();
        BeanUtils.copyProperties(dto,bo);
        return bo;
    }

    public static  SearchListDTO searchListVoToDTO(SearchListVo vo){
        if(vo == null){
            return null;
        }
        SearchListDTO dto = new SearchListDTO();
        BeanUtils.copyProperties(vo,dto);
        return dto;
    }
}
