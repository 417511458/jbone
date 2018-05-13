package cn.jbone.eb.item.core.dao.domain;

import java.sql.Timestamp;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
@Entity
@Table(name = "item_sku_stock_status")
public class ItemSkuStockStatusEntity {
    private long id;
    private long orderId;
    private long itemStockId;
    private int stockStatus;
    private int soldStatus;
    private int num;
    private String operator;
    private Timestamp addTime;
    private Timestamp updateTime;
    private int version;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "order_id")
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "item_stock_id")
    public long getItemStockId() {
        return itemStockId;
    }

    public void setItemStockId(long itemStockId) {
        this.itemStockId = itemStockId;
    }

    @Basic
    @Column(name = "stock_status")
    public int getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(int stockStatus) {
        this.stockStatus = stockStatus;
    }

    @Basic
    @Column(name = "sold_status")
    public int getSoldStatus() {
        return soldStatus;
    }

    public void setSoldStatus(int soldStatus) {
        this.soldStatus = soldStatus;
    }

    @Basic
    @Column(name = "num")
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Basic
    @Column(name = "operator")
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @CreationTimestamp
    @Basic
    @Column(name = "add_time")
    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    @UpdateTimestamp
    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Version
    @Basic
    @Column(name = "version")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}
