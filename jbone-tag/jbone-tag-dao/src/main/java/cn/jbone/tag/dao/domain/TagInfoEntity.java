package cn.jbone.tag.dao.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Id;

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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class TagInfoEntity implements Serializable{
    /**
     * 物理主键
     */
    private int id;

    /**
     * 唯一键索引，通过ID生成工具生成。
     */
    private String tagId;

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
    private Integer show;

    /**
     * 标签图标
     */
    private String icon;

    /**
     * icon类型
     * 1：CSS图标
     * 2：图片
     */
    private String iconType;

    /**
     * 点击后的跳转链接，如jbone-cms.majunwei.com/topic/111。
     */
    private String clickTarget;

    /**
     * 是否设置标签有效期，一旦新增，不能修改。
     * 0：不设置有效期
     * 1：设置有效期
     */
    private Integer timeValidity;

    /**
     * 当“timeValidity”为1时，改值必填，有效期的开始时间。
     */
    private Timestamp startTime;

    /**
     * 当“timeValidity”为1时，改值必填，有效期的结束时间。
     */
    private Timestamp endTime;

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
    private String applyReason;

    /**
     * 添加时间
     */
    private Timestamp addTime;

    /**
     * 最近修改时间
     */
    private Timestamp updateTime;

    /**
     * 版本号
     */
    private Integer version;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    @Basic
    @Column(name = "tag_id")
    public String getTagId() {
        return tagId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Basic
    @Column(name = "target")
    public Integer getTarget() {
        return target;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    @Basic
    @Column(name = "show")
    public Integer getShow() {
        return show;
    }

    @Basic
    @Column(name = "icon")
    public String getIcon() {
        return icon;
    }

    @Basic
    @Column(name = "icon_type")
    public String getIconType() {
        return iconType;
    }

    @Basic
    @Column(name = "click_target")
    public String getClickTarget() {
        return clickTarget;
    }

    @Basic
    @Column(name = "time_validity")
    public Integer getTimeValidity() {
        return timeValidity;
    }

    @Basic
    @Column(name = "start_time")
    public Timestamp getStartTime() {
        return startTime;
    }

    @Basic
    @Column(name = "end_time")
    public Timestamp getEndTime() {
        return endTime;
    }

    @Basic
    @Column(name = "extend")
    public String getExtend() {
        return extend;
    }

    @Basic
    @Column(name = "applier")
    public String getApplier() {
        return applier;
    }

    @Basic
    @Column(name = "apply_reason")
    public String getApplyReason() {
        return applyReason;
    }

    @CreationTimestamp
    @Basic
    @Column(name = "add_time")
    public Timestamp getAddTime() {
        return addTime;
    }

    @UpdateTimestamp
    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    @Version
    @Column(name = "version")
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
