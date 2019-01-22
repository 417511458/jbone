package cn.jbone.cas.client.session;

import cn.jbone.sys.common.UserResponseDO;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.subject.SimplePrincipalCollection;

import java.util.Map;

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

    public UserResponseDO getUserInfo(){
        UserResponseDO userModel = null;
        for (Map.Entry<Object,Object> entry : getAttributes().entrySet()){
            if(entry.getValue() instanceof SimplePrincipalCollection){
                SimplePrincipalCollection principalCollection = (SimplePrincipalCollection)entry.getValue();
                userModel = principalCollection.oneByType(UserResponseDO.class);
                return userModel;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
