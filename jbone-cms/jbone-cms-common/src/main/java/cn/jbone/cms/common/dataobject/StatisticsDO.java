package cn.jbone.cms.common.dataobject;

import lombok.Data;

@Data
public class StatisticsDO {
    private long articleCount;   //文章数
    private long categoryCount;  //栏目数
    private long specialCount;   //专题数
    private long hitsCount;      //文章点击数
    private long tagCount;       //标签数
    private long linkCount;      //友情链接数

}

