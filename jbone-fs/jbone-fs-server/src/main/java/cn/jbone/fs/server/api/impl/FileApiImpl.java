package cn.jbone.fs.server.api.impl;

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
        } catch (Exception e) {
            logger.error("文件上传失败");
            return Result.wrap500Error("文件上传失败");
        }
        return Result.wrapSuccess(uploadResponse);
    }

    @Override
    public Result<DownloadResponse> download(@RequestBody DownloadRequest request) {
        return null;
    }

    @Override
    public Result<DeleteResponse> delete(@RequestBody DeleteRequest request) {
        return null;
    }

    @Override
    public Result<ViewResponse> view(@RequestBody ViewRequest request) {
        return null;
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
