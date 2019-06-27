package cn.jbone.fs.server.api.impl;

import cn.jbone.common.exception.JboneException;
import cn.jbone.common.rpc.Result;
import cn.jbone.fs.api.FileApi;
import cn.jbone.fs.common.dataobject.*;
import cn.jbone.fs.repo.IFileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
public class FileApiImpl implements FileApi, HandlerExceptionResolver {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    IFileRepository fileRepository;

    @Override
    public Result<UploadResponse> upload(@RequestBody UploadRequest request) {
        UploadResponse uploadResponse = null;
        try {
            uploadResponse = fileRepository.upload(request);
        } catch (JboneException je) {
            logger.error("文件上传失败",je);
            return Result.wrap500Error(je.getMessage());
        } catch (Exception e) {
            logger.error("文件上传失败",e);
            return Result.wrap500Error("文件上传失败");
        }
        return Result.wrapSuccess(uploadResponse);
    }

    @Override
    public Result<DownloadResponse> download(@RequestBody DownloadRequest request) {
        DownloadResponse response = null;
        try{
            response = fileRepository.download(request);
        } catch (JboneException je) {
            logger.error("文件下载失败",je);
            return Result.wrap500Error(je.getMessage());
        } catch (Exception e){
            logger.error("文件下载失败",e);
            return Result.wrap500Error("文件下载失败");
        }
        return Result.wrapSuccess(response);
    }

    @Override
    public Result<Void> delete(@RequestBody DeleteRequest request) {
        try {
            fileRepository.delete(request);
        } catch (JboneException je) {
            logger.error("文件删除失败",je);
            return Result.wrap500Error(je.getMessage());
        }  catch (Exception e) {
            logger.error("文件删除失败",e);
            return Result.wrap500Error("文件删除失败");
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<ViewResponse> view(@RequestBody ViewRequest request) {
        ViewResponse response = null;
        try {
            response = fileRepository.view(request);
        } catch (JboneException je) {
            logger.error("文件查看失败",je);
            return Result.wrap500Error(je.getMessage());
        } catch (Exception e) {
            logger.error("文件查看失败",e);
            return Result.wrap500Error("文件查看失败");
        }
        return Result.wrapSuccess(response);
    }

    @RequestMapping("fileUpload")
    public Result<UploadResponse>  fileUpload(@RequestParam("file") CommonsMultipartFile file) {
        UploadRequest uploadRequest = new UploadRequest();
        uploadRequest.setBytes(file.getBytes());
        uploadRequest.setFileName(file.getFileItem().getName());
        return this.upload(uploadRequest);
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        if (e instanceof MaxUploadSizeExceededException) {
            MaxUploadSizeExceededException maxUploadSizeExceededException = (MaxUploadSizeExceededException) e;
            ModelAndView mv = new ModelAndView();
            MappingJackson2JsonView view = new MappingJackson2JsonView();
            mv.setView(view);
            mv.addObject(Result.wrap500Error("文件最大" + maxUploadSizeExceededException.getMaxUploadSize() / 1024 / 1024 + "MB"));
            return mv;
        }
        return null;
    }
}
