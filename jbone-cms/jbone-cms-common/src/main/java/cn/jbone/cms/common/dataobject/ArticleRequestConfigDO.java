package cn.jbone.cms.common.dataobject;

import lombok.Data;

@Data
public class ArticleRequestConfigDO {

    private boolean includeTags = false;
    private boolean includeCategory = false;
    private boolean includeTemplate = false;
    private boolean includeAuthor = false;
    private boolean includeContent = false;
    private boolean includeCommentCount = false;

    public ArticleRequestConfigDO(){}
    public ArticleRequestConfigDO(boolean includeTags,boolean includeCategory,boolean includeTemplate,boolean includeAuthor,boolean includeContent,boolean includeCommentCount){
        this.includeAuthor = includeAuthor;
        this.includeCategory = includeCategory;
        this.includeTags = includeTags;
        this.includeTemplate = includeTemplate;
        this.includeContent = includeContent;
        this.includeCommentCount = includeCommentCount;
    }

    public static ArticleRequestConfigDO build(){
        return new ArticleRequestConfigDO();
    }

    public static ArticleRequestConfigDO buildAll(){
        return build().includeAuthor(true).includeCategory(true).includeContent(true).includeTags(true).includeTemplate(true).includeCommentCount(true);
    }

    public ArticleRequestConfigDO includeTags(boolean includeTags){
        this.includeTags = includeTags;
        return this;
    }
    public ArticleRequestConfigDO includeCategory(boolean includeCategory){
        this.includeCategory = includeCategory;
        return this;
    }
    public ArticleRequestConfigDO includeTemplate(boolean includeTemplate){
        this.includeTemplate = includeTemplate;
        return this;
    }

    public ArticleRequestConfigDO includeAuthor(boolean includeAuthor){
        this.includeAuthor = includeAuthor;
        return this;
    }

    public ArticleRequestConfigDO includeContent(boolean includeContent){
        this.includeContent = includeContent;
        return this;
    }

    public ArticleRequestConfigDO includeCommentCount(boolean includeCommentCount){
        this.includeCommentCount = includeCommentCount;
        return this;
    }
}
