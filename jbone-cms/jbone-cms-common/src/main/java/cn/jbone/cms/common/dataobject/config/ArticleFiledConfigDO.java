package cn.jbone.cms.common.dataobject.config;

import lombok.Data;

@Data
public class ArticleFiledConfigDO {

    private boolean includeTags = false;
    private boolean includeCategory = false;
    private boolean includeTemplate = false;
    private boolean includeAuthor = false;
    private boolean includeContent = false;
    private boolean includeCommentCount = false;

    public ArticleFiledConfigDO(){}
    public ArticleFiledConfigDO(boolean includeTags, boolean includeCategory, boolean includeTemplate, boolean includeAuthor, boolean includeContent, boolean includeCommentCount){
        this.includeAuthor = includeAuthor;
        this.includeCategory = includeCategory;
        this.includeTags = includeTags;
        this.includeTemplate = includeTemplate;
        this.includeContent = includeContent;
        this.includeCommentCount = includeCommentCount;
    }

    public static ArticleFiledConfigDO build(){
        return new ArticleFiledConfigDO();
    }

    public static ArticleFiledConfigDO buildAll(){
        return build().includeAuthor(true).includeCategory(true).includeContent(true).includeTags(true).includeTemplate(true).includeCommentCount(true);
    }

    public ArticleFiledConfigDO includeTags(boolean includeTags){
        this.includeTags = includeTags;
        return this;
    }
    public ArticleFiledConfigDO includeCategory(boolean includeCategory){
        this.includeCategory = includeCategory;
        return this;
    }
    public ArticleFiledConfigDO includeTemplate(boolean includeTemplate){
        this.includeTemplate = includeTemplate;
        return this;
    }

    public ArticleFiledConfigDO includeAuthor(boolean includeAuthor){
        this.includeAuthor = includeAuthor;
        return this;
    }

    public ArticleFiledConfigDO includeContent(boolean includeContent){
        this.includeContent = includeContent;
        return this;
    }

    public ArticleFiledConfigDO includeCommentCount(boolean includeCommentCount){
        this.includeCommentCount = includeCommentCount;
        return this;
    }
}
