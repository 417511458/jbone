package cn.jbone.fs.repo.qiniu;

import cn.jbone.configuration.JboneConfiguration;
import cn.jbone.fs.common.dataobject.*;
import cn.jbone.fs.repo.IFileRepository;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class QiniuFileRepository implements IFileRepository {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    JboneConfiguration jboneConfiguration;

    @Override
    public UploadResponse upload(UploadRequest request) {

        UploadResponse uploadResponse = new UploadResponse();

        String key = UUID.randomUUID().toString().replace("-","");
        String fileName = request.getFileName();
        if(fileName.indexOf(".") != -1){
            key = key + fileName.substring(fileName.lastIndexOf("."));
        }

        Auth auth = Auth.create(jboneConfiguration.getFs().getQiniu().getAccessKey(), jboneConfiguration.getFs().getQiniu().getSecretKey());
        String upToken = auth.uploadToken(jboneConfiguration.getFs().getQiniu().getBucket());
        System.out.println(upToken);

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
        }

        return uploadResponse;
    }

    @Override
    public DownloadResponse download(DownloadRequest request) {
        return null;
    }

    @Override
    public DeleteResponse delete(DeleteRequest request) {
        return null;
    }

    @Override
    public ViewResponse view(ViewRequest request) {
        return null;
    }
}
