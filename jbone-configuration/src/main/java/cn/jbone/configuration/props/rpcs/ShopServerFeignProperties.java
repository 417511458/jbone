package cn.jbone.configuration.props.rpcs;

import lombok.Data;

import java.io.Serializable;

@Data
public class ShopServerFeignProperties implements Serializable {
    private String protocol = "http";
    private String name = "b2b2c-shop-server";  //系统服务名字
}
