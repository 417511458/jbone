package cn.jbone.tag.dao.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 标签信息实体
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/3/22 2:00
 */
@Entity
@Table(name = "tag_info")
public class TagInfoEntity implements Serializable {
    /**
     * 物理主键
     */
    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * 唯一键索引，通过ID生成工具生成。
     */
    @Basic
    @Column(name = "tag_id")
    private String tagId;

    /**
     * 标签名
     */
    @Basic
    @Column(name = "name")
    private String name;

    /**
     * 作用域，有限枚举，一旦新增，不能修改。
     * 1：店铺
     * 2：商品
     * 3：CMS文章
     * 4：CMS专题
     * 5：CMS栏目
     */
    @Basic
    @Column(name = "target")
    private Integer target;

    /**
     * 状态
     * 0：删除
     * 1：正常
     */
    @Basic
    @Column(name = "status")
    private Integer status;

    /**
     * 是否前台展示，一旦新增，不能修改。
     * 0：不展示
     * 1：展示
     */
    @Basic
    @Column(name = "show")
    private Integer show;

    /**
     * 标签图标
     */
    @Basic
    @Column(name = "icon")
    private String icon;

    /**
     * icon类型
     * 1：CSS图标
     * 2：图片
     */
    @Basic
    @Column(name = "icon_type")
    private String iconType;

    /**
     * 点击后的跳转链接，如jbone-cms.majunwei.com/topic/111。
     */
    @Basic
    @Column(name = "click_target")
    private String clickTarget;

    /**
     * 是否设置标签有效期，一旦新增，不能修改。
     * 0：不设置有效期
     * 1：设置有效期
     */
    @Basic
    @Column(name = "time_validity")
    private Integer timeValidity;

    /**
     * 当“timeValidity”为1时，改值必填，有效期的开始时间。
     */
    @Basic
    @Column(name = "start_time")
    private Timestamp startTime;

    /**
     * 当“timeValidity”为1时，改值必填，有效期的结束时间。
     */
    @Basic
    @Column(name = "end_time")
    private Timestamp endTime;

    /**
     * 预留扩展信息，json格式
     */
    @Basic
    @Column(name = "extend")
    private String extend;

    /**
     * 申请人
     */
    @Basic
    @Column(name = "applier")
    private String applier;

    /**
     * 申请说明
     */
    @Basic
    @Column(name = "apply_reason")
    private String applyReason;

    /**
     * 添加时间
     */
    @CreationTimestamp
    @Basic
    @Column(name = "add_time")
    private Timestamp addTime;

    /**
     * 最近修改时间
     */
    @UpdateTimestamp
    @Basic
    @Column(name = "update_time")
    private Timestamp updateTime;

    /**
     * 版本号
     */
    @Version
    @Column(name = "version")
    private Integer version;

    public TagInfoEntity() {
    }

    public TagInfoEntity(String tagId, String name, Integer target, Integer status, Integer show, String icon, String iconType, String clickTarget, Integer timeValidity, Timestamp startTime, Timestamp endTime, String extend, String applier, String applyReason, Timestamp addTime, Timestamp updateTime, Integer version) {
        this.tagId = tagId;
        this.name = name;
        this.target = target;
        this.status = status;
        this.show = show;
        this.icon = icon;
        this.iconType = iconType;
        this.clickTarget = clickTarget;
        this.timeValidity = timeValidity;
        this.startTime = startTime;
        this.endTime = endTime;
        this.extend = extend;
        this.applier = applier;
        this.applyReason = applyReason;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.version = version;
    }

    public int getId() {
        return id;
    }

    public String getTagId() {
        return tagId;
    }

    public String getName() {
        return name;
    }

    public Integer getTarget() {
        return target;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getShow() {
        return show;
    }

    public String getIcon() {
        return icon;
    }

    public String getIconType() {
        return iconType;
    }

    public String getClickTarget() {
        return clickTarget;
    }

    public Integer getTimeValidity() {
        return timeValidity;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public String getExtend() {
        return extend;
    }

    public String getApplier() {
        return applier;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public Timestamp getAddTime() {
        return addTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setShow(Integer show) {
        this.show = show;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setIconType(String iconType) {
        this.iconType = iconType;
    }

    public void setClickTarget(String clickTarget) {
        clickTarget = clickTarget;
    }

    public void setTimeValidity(Integer timeValidity) {
        this.timeValidity = timeValidity;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public void setApplier(String applier) {
        this.applier = applier;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
