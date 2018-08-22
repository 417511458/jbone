package cn.jbone.configuration.props;

import cn.jbone.configuration.props.rpcs.EbPortalServerProperties;
import cn.jbone.configuration.props.rpcs.ShopServerProperties;
import cn.jbone.configuration.props.rpcs.SysServerProperties;
import cn.jbone.configuration.props.rpcs.TagServerProperties;
import lombok.Data;

import java.io.Serializable;

/**
 * 远程调用配置
 */
@Data
public class RpcProperties implements Serializable {
    /**
     * 系统服务
     */
    private SysServerProperties sysServer = new SysServerProperties();
    private EbPortalServerProperties ebPortalServer = new EbPortalServerProperties();
    private ShopServerProperties shopServer = new ShopServerProperties();
    private TagServerProperties tagServer = new TagServerProperties();

}
