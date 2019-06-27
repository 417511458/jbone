package cn.jbone.fs.api;

import cn.jbone.common.rpc.Result;
import cn.jbone.fs.common.dataobject.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/file")
public interface FileApi {
    /**
     * 上传文件
     * @param request
     * @return
     */
    @RequestMapping(value = "/upload",method = {RequestMethod.POST})
    Result<UploadResponse> upload(@RequestBody UploadRequest request);

    /**
     * 下载文件,建议使用nginx等搭建专用服务，这里只是获取文件bytes和元数据，用于内部系统交互
     * @param request
     * @return
     */
    @RequestMapping(value = "/download",method = {RequestMethod.GET})
    Result<DownloadResponse> download(@RequestBody DownloadRequest request);

    /**
     * 删除文件
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete",method = {RequestMethod.DELETE})
    Result<Void> delete(@RequestBody DeleteRequest request);

    /**
     * 查看文件信息
     * @param request
     * @return
     */
    @RequestMapping(value = "/view",method = {RequestMethod.GET})
    Result<ViewResponse> view(@RequestBody ViewRequest request);
}
