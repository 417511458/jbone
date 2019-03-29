package cn.jbone.cms.common.dataobject.config;

import lombok.Data;

@Data
public class CategoryFieldConfigDO {

    private boolean includeTag;
    private boolean includeTemplate;
    private boolean includeChilds;

    public CategoryFieldConfigDO(){}
    public CategoryFieldConfigDO(boolean includeTag,boolean includeTemplate,boolean includeChilds){
        this.includeChilds = includeChilds;
        this.includeTag = includeTag;
        this.includeTemplate = includeTemplate;
    }

    public static CategoryFieldConfigDO build(){
        return new CategoryFieldConfigDO();
    }

    public static CategoryFieldConfigDO buildAll(){
        return new CategoryFieldConfigDO(true,true,true);
    }

    public CategoryFieldConfigDO includeTag(boolean includeTag){
        this.includeTag = includeTag;
        return this;
    }

    public CategoryFieldConfigDO includeTemplate(boolean includeTemplate){
        this.includeTemplate = includeTemplate;
        return this;
    }

    public CategoryFieldConfigDO includeChilds(boolean includeChilds){
        this.includeChilds = includeChilds;
        return this;
    }
}
