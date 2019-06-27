package cn.jbone.fs.repo.qiniu;

import cn.jbone.common.exception.JboneException;
import cn.jbone.configuration.JboneConfiguration;
import cn.jbone.fs.common.dataobject.*;
import cn.jbone.fs.common.utils.FileUtils;
import cn.jbone.fs.repo.IFileRepository;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class QiniuFileRepository implements IFileRepository {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    JboneConfiguration jboneConfiguration;

    @Override
    public UploadResponse upload(UploadRequest request) {

        UploadResponse uploadResponse = new UploadResponse();

        String key = UUID.randomUUID().toString().replace("-","") + FileUtils.getSuffixWithDot(request.getFileName());

        Auth auth = Auth.create(jboneConfiguration.getFs().getQiniu().getAccessKey(), jboneConfiguration.getFs().getQiniu().getSecretKey());
        String upToken = auth.uploadToken(jboneConfiguration.getFs().getQiniu().getBucket());
        Configuration cfg = new Configuration(Zone.autoZone());
        UploadManager uploadManager = new UploadManager(cfg);
        try {
            Response response = uploadManager.put(request.getBytes(), key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);

            uploadResponse.setUrl(jboneConfiguration.getFs().getQiniu().getDomain() + putRet.key);

            logger.info("上传文件成功 {}",putRet.key );
        } catch (QiniuException ex) {
            Response r = ex.response;
            logger.error("上传文件失败 {}",r.toString(),ex);
            try {
                logger.error(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
            throw new JboneException("文件上传失败");
        }

        return uploadResponse;
    }

    @Override
    public DownloadResponse download(DownloadRequest request) {
        throw new JboneException("七牛云不支持流下载，请使用图片URL直接访问");
    }

    @Override
    public void delete(DeleteRequest request) {
        Auth auth = Auth.create(jboneConfiguration.getFs().getQiniu().getAccessKey(), jboneConfiguration.getFs().getQiniu().getSecretKey());
        BucketManager bucketManager = new BucketManager(auth, new Configuration(Zone.autoZone()));
        try {
            bucketManager.delete(jboneConfiguration.getFs().getQiniu().getBucket(), FileUtils.getFileNameWithoutDomain(request.getFileUrl()));
        } catch (QiniuException ex) {
            Response r = ex.response;
            logger.error("删除文件失败 {}",r.toString(),ex);
            throw new JboneException("文件删除失败");
        }
    }

    @Override
    public ViewResponse view(ViewRequest request) {
        ViewResponse response = new ViewResponse();
        Auth auth = Auth.create(jboneConfiguration.getFs().getQiniu().getAccessKey(), jboneConfiguration.getFs().getQiniu().getSecretKey());
        BucketManager bucketManager = new BucketManager(auth, new Configuration(Zone.autoZone()));
        try {
            FileInfo fileInfo = bucketManager.stat(jboneConfiguration.getFs().getQiniu().getBucket(), FileUtils.getFileNameWithoutDomain(request.getFileUrl()));
            if(fileInfo != null){
                Map<String,String> metadata = new HashMap<>();
                metadata.put("size",fileInfo.fsize+"");
                metadata.put("mimeType",fileInfo.mimeType+"");
                metadata.put("putTime",fileInfo.putTime+"");
                response.setMetadata(metadata);
            }
        } catch (QiniuException ex) {
            Response r = ex.response;
            logger.error("查看文件失败 {}",r.toString(),ex);
            throw new JboneException("文件上传失败");
        }

        return response;
    }
}
