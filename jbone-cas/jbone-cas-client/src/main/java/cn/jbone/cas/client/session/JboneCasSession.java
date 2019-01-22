package cn.jbone.cas.client.session;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.session.mgt.SimpleSession;

/**
 * 自定义Cas Session
 */
public class JboneCasSession extends SimpleSession {
    private String serverName;

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
