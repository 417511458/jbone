package cn.jbone.configuration.props;

import cn.jbone.configuration.props.rpcs.*;
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
    private SystemServerProperties systemServer = new SystemServerProperties();
    private CmsServerProperties cmsServer = new CmsServerProperties();
    private EbPortalServerProperties ebPortalServer = new EbPortalServerProperties();
    private ShopServerProperties shopServer = new ShopServerProperties();
    private ItemServerProperties itemServer = new ItemServerProperties();
    private DecorationServerProperties decorationServer = new DecorationServerProperties();

}
