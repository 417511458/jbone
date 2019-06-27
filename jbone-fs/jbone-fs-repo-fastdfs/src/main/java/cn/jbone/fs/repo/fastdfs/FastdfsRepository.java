package cn.jbone.fs.repo.fastdfs;

import cn.jbone.common.exception.JboneException;
import cn.jbone.configuration.JboneConfiguration;
import cn.jbone.fs.common.dataobject.*;
import cn.jbone.fs.common.utils.FileUtils;
import cn.jbone.fs.repo.IFileRepository;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class FastdfsRepository implements IFileRepository {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private StorageClient1 storageClient;

    @Autowired
    private JboneConfiguration jboneConfiguration;
    private NameValuePair[] nameValuePairs;

    @Override
    public UploadResponse upload(UploadRequest request){
        UploadResponse response = new UploadResponse();
        String fileUrl = null;
        try {
            List<NameValuePair> nameValuePairs = new ArrayList<>();
            NameValuePair nameValuePair = new NameValuePair();
            nameValuePair.setName("size");
            nameValuePair.setValue(request.getBytes().length + "");
            nameValuePairs.add(nameValuePair);

            NameValuePair nameValuePair2 = new NameValuePair();
            nameValuePair2.setName("originName");
            nameValuePair2.setValue(request.getFileName());
            nameValuePairs.add(nameValuePair2);

            try {
                fileUrl = storageClient.upload_file1(request.getBytes(), FileUtils.getSuffix(request.getFileName()),nameValuePairs.toArray(new NameValuePair[nameValuePairs.size()]));
            } catch (Exception e) {
                //解决第一次上传报recv package size -1!=10,失败后重试一次
                logger.warn("失败重试一次",e);
                fileUrl = storageClient.upload_file1(request.getBytes(), FileUtils.getSuffix(request.getFileName()),nameValuePairs.toArray(new NameValuePair[nameValuePairs.size()]));
            }
        } catch (Exception e) {
            logger.error("上传文件失败",e);
            throw new JboneException("文件上传失败");
        }
        response.setUrl(fileUrl == null ? null : jboneConfiguration.getFs().getFastDfs().getDomain() + fileUrl);
        return response;
    }

    @Override
    public DownloadResponse download(DownloadRequest request) {
        DownloadResponse response = new DownloadResponse();
        try {
            byte[] bytes = storageClient.download_file1(FileUtils.getFileNameWithoutDomain(request.getFileUrl()));
            response.setBytes(bytes);

            //设置元数据
            ViewRequest viewRequest = new ViewRequest();
            viewRequest.setFileUrl(request.getFileUrl());
            ViewResponse viewResponse = this.view(viewRequest);
            if(viewRequest != null){
                response.setMetadata(viewResponse.getMetadata());
            }
        } catch (Exception e) {
            logger.error("下载文件失败",e);
            throw new JboneException("文件下载失败");
        }
        return response;
    }

    @Override
    public void delete(DeleteRequest request) {
        try {
            int count = storageClient.delete_file1(FileUtils.getFileNameWithoutDomain(request.getFileUrl()));
            if(count != 0){
                throw new JboneException("删除文件失败");
            }
        } catch (Exception e) {
            logger.error("删除文件失败",e);
            throw new JboneException("删除文件失败");
        }
    }

    @Override
    public ViewResponse view(ViewRequest request) {
        ViewResponse response = new ViewResponse();
        try {
            NameValuePair[] nameValuePairs = storageClient.get_metadata1(FileUtils.getFileNameWithoutDomain(request.getFileUrl()));
            if(nameValuePairs != null && nameValuePairs.length > 0){
                Map<String,String> metadata = new HashMap<>();
                for (NameValuePair nameValuePair:nameValuePairs){
                    metadata.put(nameValuePair.getName(),nameValuePair.getValue());
                }
                response.setMetadata(metadata);
            }
        } catch (Exception e) {
            logger.error("查看文件信息失败",e);
            throw new JboneException("查看文件信息失败");
        }

        return response;
    }
}
