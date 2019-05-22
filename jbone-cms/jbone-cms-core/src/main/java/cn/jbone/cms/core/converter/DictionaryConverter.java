package cn.jbone.cms.core.converter;

import cn.jbone.cms.common.dataobject.DictionaryDetailDO;
import cn.jbone.cms.common.dataobject.DictionaryGroupDO;
import cn.jbone.cms.core.dao.entity.DictionaryDetail;
import cn.jbone.cms.core.dao.entity.DictionaryGroup;
import cn.jbone.cms.core.dao.repository.DictionaryGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class DictionaryConverter {

    @Autowired
    private DictionaryGroupRepository dictionaryGroupRepository;

    public DictionaryGroupDO toDictionaryGroupDO(DictionaryGroup group){
        if(group == null){
            return null;
        }

        DictionaryGroupDO dictionaryGroupDO = new DictionaryGroupDO();
        dictionaryGroupDO.setId(group.getId());
        dictionaryGroupDO.setCode(group.getCode());
        dictionaryGroupDO.setName(group.getName());
        dictionaryGroupDO.setDetails(toDictionaryDetailDOs(group.getDetails()));

        return dictionaryGroupDO;
    }



    public List<DictionaryGroupDO> toDictionaryGroupDOs(List<DictionaryGroup> groups){
        if(CollectionUtils.isEmpty(groups)){
            return null;
        }
        List<DictionaryGroupDO> list = new ArrayList<>();
        for (DictionaryGroup group : groups){
            DictionaryGroupDO dictionaryGroupDO = toDictionaryGroupDO(group);
            if(dictionaryGroupDO != null){
                list.add(dictionaryGroupDO);
            }

        }
        return list;
    }

    public DictionaryGroup toDictionaryGroup(DictionaryGroupDO DO){
        if(DO == null){
            return null;
        }
        DictionaryGroup dictionaryGroup = null;
        if(DO.getId() > 0){
            dictionaryGroup = dictionaryGroupRepository.getOne(DO.getId());
        }
        if(dictionaryGroup == null){
            dictionaryGroup = new DictionaryGroup();
        }

        dictionaryGroup.setCode(DO.getCode());
        dictionaryGroup.setName(DO.getName());
        dictionaryGroup.setId(DO.getId());
        return dictionaryGroup;
    }

    public DictionaryDetailDO toDictionaryDetailDO(DictionaryDetail detail){
        if(detail == null){
            return null;
        }

        DictionaryDetailDO dictionaryDetailDO = new DictionaryDetailDO();
        dictionaryDetailDO.setDictName(detail.getDictName());
        dictionaryDetailDO.setDictPrompt(detail.getDictPrompt());
        dictionaryDetailDO.setDictValue(detail.getDictValue());
        dictionaryDetailDO.setGroupId(detail.getGroup().getId());
        dictionaryDetailDO.setId(detail.getId());
        dictionaryDetailDO.setOrders(detail.getOrders());

        return dictionaryDetailDO;
    }

    public List<DictionaryDetailDO> toDictionaryDetailDOs(List<DictionaryDetail> details){
        if(CollectionUtils.isEmpty(details)){
            return null;
        }
        List<DictionaryDetailDO> list = new ArrayList<>();
        for (DictionaryDetail detail : details){
            DictionaryDetailDO DO = toDictionaryDetailDO(detail);
            if(DO != null){
                list.add(DO);
            }
        }
        return list;
    }

    public DictionaryDetail toDictionaryDetail(DictionaryDetailDO DO){
        if(DO == null){
            return null;
        }

        DictionaryDetail detail = new DictionaryDetail();
        detail.setDictName(DO.getDictName());
        detail.setDictPrompt(DO.getDictPrompt());
        detail.setDictValue(DO.getDictValue());
        detail.setId(DO.getId());
        detail.setOrders(DO.getOrders());
        detail.setGroup(dictionaryGroupRepository.getOne(DO.getGroupId()));
        return detail;
    }
}
