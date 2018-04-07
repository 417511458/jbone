package cn.jbone.common.utils;

import cn.jbone.common.api.dto.SearchListDTO;
import cn.jbone.common.service.bo.SearchListBO;
import org.springframework.beans.BeanUtils;

public class BoDtoUtils {
    public static  SearchListBO searchListDTOToBo(SearchListDTO dto){
        if(dto == null){
            return null;
        }
        SearchListBO bo = new SearchListBO();
        BeanUtils.copyProperties(dto,bo);
        return bo;
    }

    public static  SearchListDTO searchListBoToDTO(SearchListBO bo){
        if(bo == null){
            return null;
        }
        SearchListDTO dto = new SearchListDTO();
        BeanUtils.copyProperties(bo,dto);
        return dto;
    }
}
