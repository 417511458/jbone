package cn.jbone.cms.common.dataobject;

import cn.jbone.cms.common.enums.StatusEnum;
import cn.jbone.sys.common.UserResponseDO;
import lombok.Data;

@Data
public class CommentDO {

    private Long id;

    /**
     * 评论内容
     */
    private String content;

    /**
     * IP
     */
    private String ip;

    /**
     * 状态
     */
    private StatusEnum status;

    /**
     * 评论姓名
     */
    private String username;

    /**
     * 父评论ID
     */
    private Long pid;

    /**
     * 文章ID
     */
    private Long articleId;

    private UserResponseDO author;

    /**
     * 作者ID
     */
    private Integer creator;

    private Long addTime;

    private Long updateTime;

    private String addTimeText;

    private String updateTimeText;

    private Integer siteId;
}
