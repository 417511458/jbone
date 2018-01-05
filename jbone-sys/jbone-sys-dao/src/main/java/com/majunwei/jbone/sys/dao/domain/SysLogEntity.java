package com.majunwei.jbone.sys.dao.domain;

import javax.persistence.*;

@Entity
@Table(name = "sys_log")
public class SysLogEntity {
    private int id;
    private String description;
    private String username;
    private Long startTime;
    private Integer spendTime;
    private String basePath;
    private String uri;
    private String url;
    private String method;
    private String parameter;
    private String userAgent;
    private String ip;
    private String result;
    private String permissions;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "start_time")
    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "spend_time")
    public Integer getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(Integer spendTime) {
        this.spendTime = spendTime;
    }

    @Basic
    @Column(name = "base_path")
    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    @Basic
    @Column(name = "uri")
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "method")
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Basic
    @Column(name = "parameter")
    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    @Basic
    @Column(name = "user_agent")
    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @Basic
    @Column(name = "ip")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Basic
    @Column(name = "result")
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Basic
    @Column(name = "permissions")
    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysLogEntity that = (SysLogEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (spendTime != null ? !spendTime.equals(that.spendTime) : that.spendTime != null) return false;
        if (basePath != null ? !basePath.equals(that.basePath) : that.basePath != null) return false;
        if (uri != null ? !uri.equals(that.uri) : that.uri != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (method != null ? !method.equals(that.method) : that.method != null) return false;
        if (parameter != null ? !parameter.equals(that.parameter) : that.parameter != null) return false;
        if (userAgent != null ? !userAgent.equals(that.userAgent) : that.userAgent != null) return false;
        if (ip != null ? !ip.equals(that.ip) : that.ip != null) return false;
        if (result != null ? !result.equals(that.result) : that.result != null) return false;
        if (permissions != null ? !permissions.equals(that.permissions) : that.permissions != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result1 = id;
        result1 = 31 * result1 + (description != null ? description.hashCode() : 0);
        result1 = 31 * result1 + (username != null ? username.hashCode() : 0);
        result1 = 31 * result1 + (startTime != null ? startTime.hashCode() : 0);
        result1 = 31 * result1 + (spendTime != null ? spendTime.hashCode() : 0);
        result1 = 31 * result1 + (basePath != null ? basePath.hashCode() : 0);
        result1 = 31 * result1 + (uri != null ? uri.hashCode() : 0);
        result1 = 31 * result1 + (url != null ? url.hashCode() : 0);
        result1 = 31 * result1 + (method != null ? method.hashCode() : 0);
        result1 = 31 * result1 + (parameter != null ? parameter.hashCode() : 0);
        result1 = 31 * result1 + (userAgent != null ? userAgent.hashCode() : 0);
        result1 = 31 * result1 + (ip != null ? ip.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (permissions != null ? permissions.hashCode() : 0);
        return result1;
    }
}
