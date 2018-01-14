package org.apereo.cas.web.rpc.sys;

import com.majunwei.jbone.sys.api.UserApi;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "JBONE-SYS-SERVER")
public interface UserService extends UserApi {
}
