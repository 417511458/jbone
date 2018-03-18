package cn.jbone.configuration.props;

import cn.jbone.configuration.props.rpcs.SysServerProperties;

import java.io.Serializable;

/**
 * 远程调用配置
 */
public class RpcProperties implements Serializable {
    /**
     * 系统服务
     */
    private SysServerProperties sysServer = new SysServerProperties();

    public SysServerProperties getSysServer() {
        return sysServer;
    }

    public void setSysServer(SysServerProperties sysServer) {
        this.sysServer = sysServer;
    }

    @Override
    public String toString() {
        return "RpcProperties{" +
                "sysServer=" + sysServer +
                '}';
    }
}
