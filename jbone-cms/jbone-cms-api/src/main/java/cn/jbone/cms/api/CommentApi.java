package cn.jbone.cms.api;

import cn.jbone.cms.common.dataobject.CommentDO;
import cn.jbone.common.rpc.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/comment")
public interface CommentApi {

    @RequestMapping(value = "/getByArticleId",method = {RequestMethod.GET})
    Result<List<CommentDO>> getByArticleId(@RequestParam("articleId") Long articleId);

    @RequestMapping(value = "/addOrUpdate",method = {RequestMethod.POST})
    Result<Void> addOrUpdate(@RequestBody CommentDO commentDO);

}
