package cn.jbone.fs.common.dataobject;

import lombok.Data;

import java.util.Map;

/**
 * 查看文件响应
 */
@Data
public class ViewResponse {
    private Map<String,String> metadata;
}
