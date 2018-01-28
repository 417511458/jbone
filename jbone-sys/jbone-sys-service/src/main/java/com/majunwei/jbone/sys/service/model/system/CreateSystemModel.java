package com.majunwei.jbone.sys.service.model.system;

import org.hibernate.validator.constraints.NotBlank;

public class CreateSystemModel {

    @NotBlank(message = "系统路径不能为空.")
    private String basepath;
    private Byte status;
    @NotBlank(message = "系统名不能为空.")
    private String name;
    @NotBlank(message = "系统标题不能为空.")
    private String title;
    private String description;
    private long orders;

    public String getBasepath() {
        return basepath;
    }

    public void setBasepath(String basepath) {
        this.basepath = basepath;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getOrders() {
        return orders;
    }

    public void setOrders(long orders) {
        this.orders = orders;
    }
}
