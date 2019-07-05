package cn.jbone.cms.common.dataobject;

import lombok.Data;

@Data
public class TagDO implements Comparable<TagDO>{
    /**
     * 标签ID
     */
    private Long id;

    /**
     * 标签名称
     */
    private String name;

    /**
     * 标签文章数量
     */
    private long articleCount;

    private Integer siteId;

    private Integer creator;

    /**
     * 按文章数量倒叙
     * @param o
     * @return
     */
    @Override
    public int compareTo(TagDO o) {
        if(this.getArticleCount() > o.getArticleCount()){
            return -1;
        }else if(this.getArticleCount() == o.getArticleCount()){
            return 0;
        }
        return 1;
    }
}
