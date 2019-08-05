package cn.jbone.cms.portal.controller;

import cn.jbone.cas.client.utils.SessionUtil;
import cn.jbone.cms.common.constant.DictionaryConstant;
import cn.jbone.cms.common.dataobject.ArticleResponseDO;
import cn.jbone.cms.common.dataobject.CategoryDO;
import cn.jbone.cms.common.dataobject.CategoryTocDO;
import cn.jbone.cms.common.dataobject.CommentDO;
import cn.jbone.cms.common.enums.CategoryTypeEnum;
import cn.jbone.cms.common.enums.StatusEnum;
import cn.jbone.cms.portal.collectors.DataCollectorContext;
import cn.jbone.cms.portal.collectors.DataCollectorHandler;
import cn.jbone.cms.portal.service.*;
import cn.jbone.common.rpc.Result;
import cn.jbone.errors.Jbone404Exception;
import cn.jbone.sys.common.UserResponseDO;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private CategoryService categoryService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("article/{articleId}")
    public String index(ModelMap modelMap, @PathVariable(value="articleId") long articleId, HttpServletResponse response){
        ArticleResponseDO article = articleService.findById(articleId);
        if(article == null){
            throw new Jbone404Exception();
        }

        CategoryDO categoryDO = null;
        if(article.getCategory() != null){
            categoryDO = categoryService.findById(article.getCategory().getId());
        }
        if(categoryDO == null){
            throw new Jbone404Exception();
        }

        //如果是专题文章，则重定向到专题页
        if(categoryDO.getType() == CategoryTypeEnum.SPECIAL){
            CategoryTocDO categoryTocDO = categoryService.getTocByCategoryAndArticle(categoryDO.getId(),articleId);
            if(categoryDO != null){
                return "redirect:/category/" + categoryDO.getCode() + "/" + categoryTocDO.getId();
            }
        }

        articleService.toArticleDetail(modelMap,article,categoryDO);


        DataCollectorContext context = DataCollectorContext.build(modelMap, DictionaryConstant.ITEM_PAGE_NAME_ARTICLE);
        context.setArticle(article);
        context.setCategory(categoryDO);
        dataCollectorHandler.handle(context);
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
