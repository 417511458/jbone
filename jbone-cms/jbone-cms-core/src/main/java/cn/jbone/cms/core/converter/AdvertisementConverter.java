package cn.jbone.cms.core.converter;

import cn.jbone.cms.common.dataobject.AdvertisementDO;
import cn.jbone.cms.core.dao.entity.Advertisement;
import cn.jbone.cms.core.dao.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AdvertisementConverter {
    @Autowired
    private AdvertisementRepository advertisementRepository;

    public AdvertisementDO toDO(Advertisement advertisement){
        if(advertisement == null){
            return null;
        }
        AdvertisementDO advertisementDO = new AdvertisementDO();
        advertisementDO.setContent(advertisement.getContent());
        advertisementDO.setEnable(advertisement.getEnable());
        advertisementDO.setId(advertisement.getId());
        advertisementDO.setLocation(advertisement.getLocation());
        advertisementDO.setName(advertisement.getName());
        advertisementDO.setType(advertisement.getType());
        advertisementDO.setUrl(advertisement.getUrl());
        advertisementDO.setHits(advertisement.getHits());
        advertisementDO.setImg(advertisement.getImg());
        advertisementDO.setText(advertisement.getText());
        advertisementDO.setSiteId(advertisement.getSiteId());
        return advertisementDO;
    }

    public List<AdvertisementDO> toDOS(List<Advertisement> advertisements){
        if(CollectionUtils.isEmpty(advertisements)){
            return null;
        }

        List<AdvertisementDO> advertisementDOS = new ArrayList<>();
        for (Advertisement advertisement:advertisements) {
            AdvertisementDO advertisementDO = toDO(advertisement);
            if(advertisementDO != null){
                advertisementDOS.add(advertisementDO);
            }
        }
        return advertisementDOS;
    }

    public Map<String,List<AdvertisementDO>> toDOSMap(List<Advertisement> advertisements){
        if(CollectionUtils.isEmpty(advertisements)){
            return null;
        }

        Map<String,List<AdvertisementDO>> advertisementDOSMap = new HashMap<>();
        for (Advertisement advertisement:advertisements) {
            AdvertisementDO advertisementDO = toDO(advertisement);

            if(advertisementDO != null){
                List<AdvertisementDO> advertisementDOS = advertisementDOSMap.get(advertisementDO.getLocation());
                if(CollectionUtils.isEmpty(advertisementDOS)){
                    advertisementDOS = new ArrayList<>();
                    advertisementDOSMap.put(advertisementDO.getLocation(),advertisementDOS);
                }
                advertisementDOS.add(advertisementDO);
            }
        }
        return advertisementDOSMap;
    }

    public Advertisement toEntity(AdvertisementDO advertisementDO){
        if(advertisementDO == null){
            return null;
        }

        Advertisement advertisement = null;
        if(advertisementDO.getId() != null && advertisementDO.getId() > 0){
            advertisement = advertisementRepository.getOne(advertisementDO.getId());
        }
        if(advertisement == null){
            advertisement = new Advertisement();
        }
        advertisement.setContent(advertisementDO.getContent());
        advertisement.setEnable(advertisementDO.getEnable());
        advertisement.setId(advertisementDO.getId());
        advertisement.setLocation(advertisementDO.getLocation());
        advertisement.setName(advertisementDO.getName());
        advertisement.setType(advertisementDO.getType());
        advertisement.setUrl(advertisementDO.getUrl());
//        advertisement.setHits(advertisementDO.getHits());
        advertisement.setImg(advertisementDO.getImg());
        advertisement.setText(advertisementDO.getText());
        advertisement.setSiteId(advertisementDO.getSiteId());
        return advertisement;
    }

    public List<Advertisement> toEntitiys(List<AdvertisementDO> advertisementDOS){
        if(CollectionUtils.isEmpty(advertisementDOS)){
            return null;
        }

        List<Advertisement> advertisements = new ArrayList<>();
        for (AdvertisementDO advertisementDO:advertisementDOS) {
            Advertisement advertisement = toEntity(advertisementDO);
            if(advertisement != null){
                advertisements.add(advertisement);
            }
        }
        return advertisements;

    }

}
