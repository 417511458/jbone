package cn.jbone.sys.common;

import lombok.Data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Data
public class UserRequestDO implements Serializable {

    Integer userId;

    String username;

    List<UserRequestModule> modules = Arrays.asList(UserRequestModule.BASE);

    String serverName;

    public UserRequestDO(){}

    public UserRequestDO(Integer userId){
        this.userId = userId;
    }

    public UserRequestDO(Integer userId,List<UserRequestModule> userRequestModules){
        this.userId = userId;
        modules.addAll(userRequestModules);
    }

    public static UserRequestDO buildSimple(String username){
        UserRequestDO userRequestDO = new UserRequestDO();
        userRequestDO.setUsername(username);
        return userRequestDO;
    }

    public static UserRequestDO buildSimple(Integer userId){
        UserRequestDO userRequestDO = new UserRequestDO();
        userRequestDO.setUserId(userId);
        return userRequestDO;
    }

    public static UserRequestDO buildSecurity(String username){
        UserRequestDO userRequestDO = new UserRequestDO();
        userRequestDO.setUsername(username);
        userRequestDO.setModules(Arrays.asList(UserRequestModule.BASE,UserRequestModule.SECURITY));
        return userRequestDO;
    }

    public static UserRequestDO buildSecurity(Integer userId){
        UserRequestDO userRequestDO = new UserRequestDO();
        userRequestDO.setUserId(userId);
        userRequestDO.setModules(Arrays.asList(UserRequestModule.BASE,UserRequestModule.SECURITY));
        return userRequestDO;
    }

    public static UserRequestDO buildAll(Integer userId,String serverName){
        UserRequestDO userRequestDO = new UserRequestDO();
        userRequestDO.setUserId(userId);
        userRequestDO.setModules(Arrays.asList(UserRequestModule.BASE,UserRequestModule.AUTH,UserRequestModule.SECURITY));
        userRequestDO.setServerName(serverName);
        return userRequestDO;
    }

    public static UserRequestDO buildAll(String username,String serverName){
        UserRequestDO userRequestDO = new UserRequestDO();
        userRequestDO.setUsername(username);
        userRequestDO.setModules(Arrays.asList(UserRequestModule.BASE,UserRequestModule.AUTH,UserRequestModule.SECURITY));
        userRequestDO.setServerName(serverName);
        return userRequestDO;
    }

    public enum UserRequestModule{
        BASE,SECURITY,AUTH
    }

    public boolean containsModule(UserRequestModule userRequestModule){
        return modules.contains(userRequestModule);
    }
}
