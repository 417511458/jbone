package cn.jbone.cms.portal.collectors;

import cn.jbone.cms.portal.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("commentsCollector")
public class CommentsCollector implements IDataCollector {

    @Autowired
    private CommentService commentService;

    private String DATA_KEY = "comments";

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void collect(DataCollectorContext context) {
        if(context.getArticle() == null){
            logger.warn("收集文章评论，却没找到文章。");
            return;
        }
        context.addAttribute(DATA_KEY,commentService.getByArticleId(context.getArticle().getId()));
    }
}
