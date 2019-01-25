package cn.jbone.cms.core.converter;

import lombok.Data;

@Data
public class CategoryFieldConfig {
    private boolean tag;
    private boolean template;
    private boolean childs;

    public static CategoryFieldConfig buildAll(){
        CategoryFieldConfig config = new CategoryFieldConfig();
        config.tag = true;
        config.template = true;
        config.childs = true;
        return config;
    }

    public static CategoryFieldConfig build(){
        CategoryFieldConfig config = new CategoryFieldConfig();
        config.tag = true;
        config.template = true;
        config.childs = false;
        return config;
    }

    public static CategoryFieldConfig buildSimple(){
        CategoryFieldConfig config = new CategoryFieldConfig();
        config.tag = false;
        config.template = false;
        config.childs = false;
        return config;
    }
}
