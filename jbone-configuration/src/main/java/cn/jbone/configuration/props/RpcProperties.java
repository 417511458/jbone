package cn.jbone.configuration.props;

import cn.jbone.configuration.props.rpcs.EbPortalServerProperties;
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
    private EbPortalServerProperties ebPortalServer = new EbPortalServerProperties();

    public SysServerProperties getSysServer() {
        return sysServer;
    }

    public void setSysServer(SysServerProperties sysServer) {
        this.sysServer = sysServer;
    }

    public EbPortalServerProperties getEbPortalServer() {
        return ebPortalServer;
    }

    public void setEbPortalServer(EbPortalServerProperties ebPortalServer) {
        this.ebPortalServer = ebPortalServer;
    }

    @Override
    public String toString() {
        return "RpcProperties{" +
                "sysServer=" + sysServer +
                ", ebPortalServer=" + ebPortalServer +
                '}';
    }
}
