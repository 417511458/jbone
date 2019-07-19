package cn.jbone.cms.portal.controller;

import cn.jbone.cas.client.utils.SessionUtil;
import cn.jbone.cms.common.constant.DictionaryConstant;
import cn.jbone.cms.common.dataobject.CommentDO;
import cn.jbone.cms.common.enums.StatusEnum;
import cn.jbone.cms.portal.collectors.DataCollectorContext;
import cn.jbone.cms.portal.collectors.DataCollectorHandler;
import cn.jbone.cms.portal.service.*;
import cn.jbone.common.exception.ObjectNotFoundException;
import cn.jbone.common.rpc.Result;
import cn.jbone.errors.PageCode;
import cn.jbone.sys.common.UserResponseDO;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class ArticleController {

    @Autowired
    private CommonService commonService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private DataCollectorHandler dataCollectorHandler;

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("article/{articleId}")
    public String index(ModelMap modelMap, @PathVariable(value="articleId") long articleId, HttpServletResponse response){
        articleService.toArticleDetail(modelMap,articleId);
        dataCollectorHandler.handle(DataCollectorContext.build(modelMap, DictionaryConstant.ITEM_PAGE_NAME_ARTICLE));
        return commonService.getTemplatePage(DictionaryConstant.ITEM_PAGE_NAME_ARTICLE);
    }

    @RequestMapping("article/submitComment")
    @ResponseBody
    public Result index(ModelMap modelMap, CommentDO commentDO, HttpServletRequest request){
        try {
            UserResponseDO userResponseDO = SessionUtil.getCurrentUser();
            if(userResponseDO == null){
                return Result.wrap500Error("请先登录");
            }
            commentDO.setStatus(StatusEnum.PUBLISH);
            commentDO.setPid(0l);
            commentDO.setIp(request.getRemoteHost());
            commentDO.setCreator(userResponseDO.getBaseInfo().getId());
            if(commentService.addOrUpdate(commentDO)){
                return Result.wrapSuccess();
            }else{
                return Result.wrap500Error("评论失败，请稍后重试");
            }
        } catch (Exception e) {
            logger.info("评论失败 {}", JSON.toJSONString(commentDO),e);
            return Result.wrap500Error("评论失败，请稍后重试");
        }
    }
}
