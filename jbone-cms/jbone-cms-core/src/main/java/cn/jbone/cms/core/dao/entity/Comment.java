package cn.jbone.cms.core.dao.entity;

import cn.jbone.cms.common.enums.StatusEnum;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "comment")
public class Comment extends BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableGenerator(name = "comment", initialValue = 1000)
    private Long id;

    /**
     * 评论内容
     */
    @Column(name = "content",columnDefinition="text")
    private String content;

    /**
     * IP
     */
    @Column(name = "ip")
    private String ip;

    /**
     * 状态
     */
    @Column(name = "status")
    private StatusEnum status;

    /**
     * 评论姓名
     */
    @Column(name = "username")
    private String username;

    /**
     * 父评论ID
     */
    @Column(name = "pid")
    private Long pid;

    /**
     * 文章ID
     */
    @Column(name = "article_id")
    private Long articleId;


}
