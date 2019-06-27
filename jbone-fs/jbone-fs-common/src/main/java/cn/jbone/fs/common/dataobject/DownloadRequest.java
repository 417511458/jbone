package cn.jbone.fs.common.dataobject;

import lombok.Data;

/**
 * 下载请求
 */
@Data
public class DownloadRequest {
    private String fileUrl; //文件路径，可带域名
}
