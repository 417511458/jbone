package cn.jbone.bpm.admin.handlers;

import cn.jbone.common.exception.JboneException;
import cn.jbone.common.ui.result.Result;
import cn.jbone.common.utils.ResultUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 处理绑定Model异常，使用Hibernate Validator作验证框架
 */
@Aspect
@Component
public class BindingExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Around("execution(cn.jbone.common.ui.result.Result cn.jbone.tag.admin.controller.*.*(..))")
    public Result doAround(ProceedingJoinPoint pjp) throws Throwable {

        BindingResult bindingResult = null;
        for(Object arg:pjp.getArgs()){
            if(arg instanceof BindingResult){
                bindingResult = (BindingResult) arg;
            }
        }
        if(bindingResult != null && bindingResult.hasErrors()){
            String msg = getErrors(bindingResult);
            return ResultUtils.wrapFail(msg);
        }

        Result result = null;
        try {
            result = (Result) pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            if(throwable instanceof JboneException){
                JboneException exception = (JboneException) throwable;
                return ResultUtils.wrapFail(exception.getMessage());
            }else{
                return ResultUtils.wrapFail("系统错误！");
            }
        }
        return result;
    }

    private String getErrors(BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            List<ObjectError> errors = bindingResult.getAllErrors();
            StringBuffer message = new StringBuffer();
            for (ObjectError error: errors) {
                message.append(error.getDefaultMessage()).append("\n");
            }
            request.setAttribute("errorMessage",message);
            return message.toString();
        }
        return "未知错误";
    }

}
