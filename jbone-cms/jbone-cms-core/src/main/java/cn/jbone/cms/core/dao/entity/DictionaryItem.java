package cn.jbone.cms.core.dao.entity;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Data
@Entity
@Table(name = "dictionary_item")
public class DictionaryItem extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableGenerator(name = "dictionary_group", initialValue = 1000)
    private Integer id;

    /**
     * 所属字典组
     */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "group_id",referencedColumnName = "id")
    @NotFound(action= NotFoundAction.IGNORE)
    private DictionaryGroup group;

    /**
     * 字典名，如男/女
     */
    @Column(name = "dict_name")
    private String dictName;

    /**
     * 字典值，如male/femail
     */
    @Column(name = "dict_value")
    private String dictValue;

    /**
     * 字典展示在前端的提示文本
     */
    @Column(name = "dict_prompt")
    private String dictPrompt;

    /**
     * 排序号
     */
    @Column(name = "orders")
    private int orders;

}
