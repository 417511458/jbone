package cn.jbone.fs.common.dataobject;

import lombok.Data;

/**
 * 上传请求
 */
@Data
public class UploadRequest {
    private String localFilePath;
    private byte[] bytes;
    private String fileName;
}
