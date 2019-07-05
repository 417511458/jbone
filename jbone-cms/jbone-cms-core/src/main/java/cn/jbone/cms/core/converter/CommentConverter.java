package cn.jbone.cms.core.converter;

import cn.jbone.cms.common.dataobject.*;
import cn.jbone.cms.core.dao.entity.Comment;
import cn.jbone.common.rpc.Result;
import cn.jbone.common.utils.DateUtil;
import cn.jbone.sys.api.UserApi;
import cn.jbone.sys.common.UserRequestDO;
import cn.jbone.sys.common.UserResponseDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommentConverter {

    @Autowired
    private UserApi userApi;

    public CommentDO toCommentDO(Comment comment){
        if(comment == null){
            return null;
        }

        CommentDO commentDO = new CommentDO();
        commentDO.setAddTime(comment.getAddTime().getTime());
        commentDO.setAddTimeText(DateUtil.formateDate(comment.getAddTime(),DateUtil.DATE_FORMAT));
        commentDO.setArticleId(comment.getArticleId());
        commentDO.setContent(comment.getContent());
        commentDO.setCreator(comment.getCreator());
        commentDO.setId(comment.getId());
        commentDO.setIp(comment.getIp());
        commentDO.setPid(comment.getPid());
        commentDO.setStatus(comment.getStatus());
        commentDO.setSiteId(comment.getSiteId());

        UserRequestDO userRequestDO = UserRequestDO.buildSimple(comment.getCreator());
        Result<UserResponseDO> responseResult =  userApi.commonRequest(userRequestDO);
        if(responseResult != null && responseResult.isSuccess()){
            commentDO.setAuthor(responseResult.getData());
        }

        return commentDO;
    }

    public List<CommentDO> toCommentDOs(List<Comment> comments){
        if(CollectionUtils.isEmpty(comments)){
            return null;
        }

        List<CommentDO> commentDOS = new ArrayList<>();
        for (Comment comment : comments){
            CommentDO commentDO = toCommentDO(comment);
            if(commentDO != null){
                commentDOS.add(commentDO);
            }
        }
        return commentDOS;
    }

    public Comment toComment(CommentDO commentDO){
        if(commentDO == null){
            return null;
        }

        Comment comment = new Comment();
        comment.setArticleId(commentDO.getArticleId());
        comment.setContent(commentDO.getContent());
        comment.setCreator(commentDO.getCreator());
        comment.setIp(commentDO.getIp());
        comment.setPid(commentDO.getPid());
        comment.setStatus(commentDO.getStatus());
        comment.setSiteId(commentDO.getSiteId());
        return comment;
    }
}
