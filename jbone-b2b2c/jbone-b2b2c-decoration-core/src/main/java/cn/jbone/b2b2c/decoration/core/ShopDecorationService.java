package cn.jbone.b2b2c.decoration.core;

import cn.jbone.b2b2c.decoration.api.dto.response.ShopDecorationInfoRespDTO;
import cn.jbone.b2b2c.decoration.core.consts.CommonConstant;
import cn.jbone.b2b2c.decoration.core.dao.domain.DecorationTemplateEntity;
import cn.jbone.b2b2c.decoration.core.dao.domain.ShopDecorationTemplateEntity;
import cn.jbone.b2b2c.decoration.core.dao.repository.ShopDecorationTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopDecorationService {
    @Autowired
    private ShopDecorationTemplateRepository shopDecorationTemplateRepository;

    public ShopDecorationInfoRespDTO getShopDecorationInfo(long shopId){
        ShopDecorationTemplateEntity shopDecorationTemplateEntity = shopDecorationTemplateRepository.findByShopId(shopId);
        if(shopDecorationTemplateEntity == null || shopDecorationTemplateEntity.getStatus() != CommonConstant.STATUS_VALID){
            return getDefault();
        }

        DecorationTemplateEntity decorationTemplateEntity = shopDecorationTemplateEntity.getDecorationTemplate();
        if(decorationTemplateEntity == null || decorationTemplateEntity.getStatus() != CommonConstant.STATUS_VALID){
            return getDefault();
        }

        ShopDecorationInfoRespDTO decorationInfoRespDTO = new ShopDecorationInfoRespDTO();
        decorationInfoRespDTO.setStatus(decorationTemplateEntity.getStatus());
        decorationInfoRespDTO.setTemplateCode(decorationTemplateEntity.getCode());
        decorationInfoRespDTO.setTemplateId(decorationTemplateEntity.getId());
        decorationInfoRespDTO.setTemplateName(decorationTemplateEntity.getName());
        decorationInfoRespDTO.setTemplateDescription(decorationTemplateEntity.getDescription());
        return decorationInfoRespDTO;

    }

    private ShopDecorationInfoRespDTO getDefault(){
        ShopDecorationInfoRespDTO decorationInfoRespDTO = new ShopDecorationInfoRespDTO();
        decorationInfoRespDTO.setStatus(1);
        decorationInfoRespDTO.setTemplateCode("default");
        decorationInfoRespDTO.setTemplateId(0);
        decorationInfoRespDTO.setTemplateName("默认模版");
        decorationInfoRespDTO.setTemplateDescription("默认模版");
        return decorationInfoRespDTO;
    }
}
