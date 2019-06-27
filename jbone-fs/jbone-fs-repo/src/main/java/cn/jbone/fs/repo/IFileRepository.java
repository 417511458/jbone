package cn.jbone.fs.repo;

import cn.jbone.fs.common.dataobject.*;

/**
 * 文件存储接口
 */
public interface IFileRepository {
    /**
     * 上传文件
     * @param request
     * @return
     */
    UploadResponse upload(UploadRequest request);

    /**
     * 下载文件
     * @param request
     * @return
     */
    DownloadResponse download(DownloadRequest request);

    /**
     * 删除文件
     * @param request
     * @return
     */
    void delete(DeleteRequest request);


    /**
     * 查看文件信息
     * @param request
     * @return
     */
    ViewResponse view(ViewRequest request);
}
