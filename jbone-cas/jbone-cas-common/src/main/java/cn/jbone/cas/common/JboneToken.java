package cn.jbone.cas.common;

import cn.jbone.sys.common.UserResponseDO;

import java.io.Serializable;
import java.util.Map;

public class JboneToken implements Serializable {
    public static final String PREFIX = "jbone:";
    private long creationTime;
    private String id;
    private long timeout;
    private UserResponseDO userResponseDO;
    private Map<String,Object> attributes;

    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public UserResponseDO getUserResponseDO() {
        return userResponseDO;
    }

    public void setUserResponseDO(UserResponseDO userResponseDO) {
        this.userResponseDO = userResponseDO;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
}
