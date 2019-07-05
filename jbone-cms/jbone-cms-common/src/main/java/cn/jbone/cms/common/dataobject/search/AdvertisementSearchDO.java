package cn.jbone.cms.common.dataobject.search;

import cn.jbone.common.dataobject.SearchListDO;
import lombok.Data;

@Data
public class AdvertisementSearchDO extends SearchListDO {
    private String location;
    private String type;
    private String name;
    private int enable;
    private Long id;
    private Integer siteId;

    public static AdvertisementSearchDO build(String location){
        AdvertisementSearchDO advertisementSearchDO = new AdvertisementSearchDO();
        advertisementSearchDO.setLocation(location);
        return advertisementSearchDO;
    }

    public AdvertisementSearchDO location(String location){
        this.location = location;
        return this;
    }

    public AdvertisementSearchDO type(String type){
        this.type = type;
        return this;
    }

    public AdvertisementSearchDO name(String name){
        this.name = name;
        return this;
    }

    public AdvertisementSearchDO enable(){
        this.enable = 1;
        return this;
    }
    public AdvertisementSearchDO disenable(){
        this.enable = 0;
        return this;
    }
}
