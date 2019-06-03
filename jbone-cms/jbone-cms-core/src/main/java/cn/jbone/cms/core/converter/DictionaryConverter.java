package cn.jbone.cms.core.converter;

import cn.jbone.cms.common.dataobject.DictionaryItemDO;
import cn.jbone.cms.common.dataobject.DictionaryGroupDO;
import cn.jbone.cms.common.dataobject.InnerDictionaryItemDO;
import cn.jbone.cms.core.dao.entity.DictionaryItem;
import cn.jbone.cms.core.dao.entity.DictionaryGroup;
import cn.jbone.cms.core.dao.repository.DictionaryGroupRepository;
import cn.jbone.cms.core.dao.repository.DictionaryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class DictionaryConverter {

    @Autowired
    private DictionaryGroupRepository dictionaryGroupRepository;
    @Autowired
    private DictionaryItemRepository dictionaryItemRepository;

    public DictionaryGroupDO toDictionaryGroupDO(DictionaryGroup group){
        if(group == null){
            return null;
        }

        DictionaryGroupDO dictionaryGroupDO = new DictionaryGroupDO();
        dictionaryGroupDO.setId(group.getId());
        dictionaryGroupDO.setCode(group.getCode());
        dictionaryGroupDO.setName(group.getName());
        dictionaryGroupDO.setItems(toDictionaryItemDOs(group.getItems()));

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

    public DictionaryItemDO toDictionaryItemDO(DictionaryItem item){
        if(item == null){
            return null;
        }

        DictionaryItemDO dictionaryItemDO = new DictionaryItemDO();
        dictionaryItemDO.setDictName(item.getDictName());
        dictionaryItemDO.setDictPrompt(item.getDictPrompt());
        dictionaryItemDO.setDictValue(item.getDictValue());
        dictionaryItemDO.setGroupId(item.getGroup().getId());
        dictionaryItemDO.setId(item.getId());
        dictionaryItemDO.setOrders(item.getOrders());

        return dictionaryItemDO;
    }

    public List<DictionaryItemDO> toDictionaryItemDOs(List<DictionaryItem> items){
        if(CollectionUtils.isEmpty(items)){
            return null;
        }
        List<DictionaryItemDO> list = new ArrayList<>();
        for (DictionaryItem item : items){
            DictionaryItemDO DO = toDictionaryItemDO(item);
            if(DO != null){
                list.add(DO);
            }
        }
        return list;
    }

    public DictionaryItem toDictionaryItem(DictionaryItemDO DO){
        if(DO == null){
            return null;
        }
        DictionaryItem item = null;
        if(DO.getId() > 0){
            item = dictionaryItemRepository.getOne(DO.getId());
        }
        if(item == null){
            item = new DictionaryItem();
        }
        item.setDictName(DO.getDictName());
        item.setDictPrompt(DO.getDictPrompt());
        item.setDictValue(DO.getDictValue());
        item.setId(DO.getId());
        item.setOrders(DO.getOrders());
        item.setGroup(dictionaryGroupRepository.getOne(DO.getGroupId()));
        return item;
    }

    public InnerDictionaryItemDO toInnerDictionaryItemDO(DictionaryItemDO DO){
        if(DO == null){
            return  null;
        }
        InnerDictionaryItemDO innerDictionaryItemDO = new InnerDictionaryItemDO();
        innerDictionaryItemDO.setName(DO.getDictName());
        innerDictionaryItemDO.setPrompt(DO.getDictPrompt());
        innerDictionaryItemDO.setValue(DO.getDictValue());
        return innerDictionaryItemDO;
    }
}
