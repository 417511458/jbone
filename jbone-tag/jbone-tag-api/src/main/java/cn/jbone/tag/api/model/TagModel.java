package cn.jbone.tag.api.model;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/3/21 23:15
 */
@Data
public class TagModel implements Serializable{

    /**
     * 物理主键
     */
    private int id;

    /**
     * 标签名
     */
    private String name;

    /**
     * 作用域，有限枚举，一旦新增，不能修改。
     * 1：店铺
     * 2：商品
     * 3：CMS文章
     * 4：CMS专题
     * 5：CMS栏目
     */
    private Integer target;

    /**
     * 状态
     * 0：删除
     * 1：正常
     */
    private Integer status;

    /**
     * 是否前台展示，一旦新增，不能修改。
     * 0：不展示
     * 1：展示
     */
    private Integer isShow;

    /**
     * 标签图标
     */
    private String icon;

    /**
     * icon类型
     * 1：CSS图标
     * 2：图片
     */
    private String icon_type;

    /**
     * 点击后的跳转链接，如jbone-cms.majunwei.com/topic/111。
     */
    private String click_target;

    /**
     * 是否设置标签有效期，一旦新增，不能修改。
     * 0：不设置有效期
     * 1：设置有效期
     */
    private Integer time_validity;

    /**
     * 当“timeValidity”为1时，改值必填，有效期的开始时间。
     */
    private Timestamp start_time;

    /**
     * 当“timeValidity”为1时，改值必填，有效期的结束时间。
     */
    private Timestamp end_time;

    /**
     * 预留扩展信息，json格式
     */
    private String extend;

    /**
     * 申请人
     */
    private String applier;

    /**
     * 申请说明
     */
    private String apply_reason;

}
