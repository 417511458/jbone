package cn.jbone.cms.core.validator;

import cn.jbone.cms.core.dao.repository.SiteAdminRepository;
import cn.jbone.cms.core.dao.repository.SiteRepository;
import cn.jbone.common.exception.JboneException;
import cn.jbone.common.rpc.Result;
import cn.jbone.sys.api.UserApi;
import cn.jbone.sys.common.UserRequestDO;
import cn.jbone.sys.common.UserResponseDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContentValidator {

    @Autowired
    private UserApi userApi;

    @Autowired
    private SiteRepository siteRepository;

    @Autowired
    private SiteAdminRepository siteAdminRepository;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public void checkPermition(Integer userId,Integer siteId){
        logger.info("userId:{},siteId:{}",userId,siteId);
        if(userId == null || userId <= 0 || siteId == null || siteId <= 0){
            throw new JboneException(JboneException.ILLEGAL_PARAM);
        }

        Result<UserResponseDO> userResponseDOResult = userApi.commonRequest(UserRequestDO.buildSimple(userId));
        if(userResponseDOResult == null || !userResponseDOResult.isSuccess() || userResponseDOResult.getData() == null){
            throw new JboneException(JboneException.USER_IS_NOT_FOUND);
        }

        if(!siteRepository.existsById(siteId)){
            throw new JboneException(JboneException.SITE_IS_NOT_FOUND);
        }

        if(!siteAdminRepository.existsBySiteIdAndUserId(siteId,userId)){
            throw new JboneException(JboneException.PERMISSION_DENIED);
        }
    }
}
