package cn.jbone.cms.common.dataobject;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class SettingsDO {

    private Long id;
    /**
     * 标题
     */
    private String settingKey;

    /**
     * 封面图
     */
    private String settingValue;

    /**
     * 描述，用于功能介绍
     */
    private String description;

    /**
     * 添加时间
     */
    private Timestamp addTime;

    /**
     * 更新时间
     */
    private Timestamp updateTime;

    /**
     * 创建者
     */
    private Integer creator;

}
