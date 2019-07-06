package cn.jbone.cms.core.service;

import cn.jbone.cms.common.constant.SiteSettingConstant;
import cn.jbone.cms.common.dataobject.CommentDO;
import cn.jbone.cms.core.converter.CommentConverter;
import cn.jbone.cms.core.dao.entity.Article;
import cn.jbone.cms.core.dao.entity.Comment;
import cn.jbone.cms.core.dao.repository.ArticleRepository;
import cn.jbone.cms.core.dao.repository.CommentRepository;
import cn.jbone.common.exception.JboneException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentConverter commentConverter;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private SiteSettingsService siteSettingsService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public List<CommentDO> getByArticleId(Long articleId){
        List<Comment> commentList = commentRepository.findByArticleIdOrderByAddTimeDesc(articleId);
        return commentConverter.toCommentDOs(commentList);
    }

    public void addOrUpdate(CommentDO commentDO){

        Article article = articleRepository.getOne(commentDO.getArticleId());
        if(article == null){
            throw new JboneException("文章不存在");
        }
        commentDO.setSiteId(article.getSiteId());

        checkLimit(commentDO);

        Comment comment = commentConverter.toComment(commentDO);
        commentRepository.save(comment);
    }

    private void checkLimit(CommentDO commentDO){
        if(commentDO.getId() == null || commentDO.getId() <= 0){
            Map<String, String> settingMap = siteSettingsService.getSettingsMap(commentDO.getSiteId());
            if(!settingMap.containsKey(SiteSettingConstant.LIMIT_COMMENT_COUNT)){
                throw new JboneException("本站禁止添加评论，如有疑问请联系管理员.");
            }
            Long limitCount = Long.parseLong(settingMap.get(SiteSettingConstant.LIMIT_COMMENT_COUNT));
            if(limitCount <= 0){
                logger.warn("超过评论限额{}",limitCount);
                throw new JboneException("本站评论数太多了");
            }
            long currentCount = commentRepository.countBySiteId(commentDO.getSiteId());
            if(currentCount >= limitCount){
                logger.warn("超过评论限额{}",limitCount);
                throw new JboneException("本站评论数太多了");
            }
        }
    }


}
