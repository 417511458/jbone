package cn.jbone.sys.common;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class UserRequestDO {

    Integer userId;

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

    public enum UserRequestModule{
        BASE,SECURITY,AUTH
    }

    public boolean containsModule(UserRequestModule userRequestModule){
        return modules.contains(userRequestModule);
    }
}
