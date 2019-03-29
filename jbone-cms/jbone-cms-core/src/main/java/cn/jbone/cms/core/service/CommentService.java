package cn.jbone.cms.core.service;

import cn.jbone.cms.common.dataobject.CommentDO;
import cn.jbone.cms.core.converter.CommentConverter;
import cn.jbone.cms.core.dao.entity.Comment;
import cn.jbone.cms.core.dao.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentConverter commentConverter;

    public List<CommentDO> getByArticleId(Long articleId){
        List<Comment> commentList = commentRepository.findByArticleIdOrderByAddTimeDesc(articleId);
        return commentConverter.toCommentDOs(commentList);
    }

    public void addOrUpdate(CommentDO commentDO){
        Comment comment = commentConverter.toComment(commentDO);
        commentRepository.save(comment);
    }


}
