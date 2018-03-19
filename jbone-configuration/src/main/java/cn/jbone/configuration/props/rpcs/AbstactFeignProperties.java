package cn.jbone.configuration.props.rpcs;

import java.io.Serializable;

public class AbstactFeignProperties implements Serializable {
    private String protocol = "http";
    private String name = "";  //系统服务名字

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
