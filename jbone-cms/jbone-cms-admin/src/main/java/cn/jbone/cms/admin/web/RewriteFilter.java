package cn.jbone.cms.admin.web;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * 重写UI的URL，交由VUE的router处理
 */
public class RewriteFilter implements Filter {

    public static final String REWRITE_TO = "rewriteToUrl";
    public static final String REWRITE_PATTERNS = "urlPatterns";

    private String rewriteTo;

    private Set<String> urlPatterns;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        rewriteTo = filterConfig.getInitParameter(REWRITE_TO);
        String patterns = filterConfig.getInitParameter(REWRITE_PATTERNS);
        if(StringUtils.isNotBlank(patterns)){
            urlPatterns = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(patterns.split(","))));
        }else{
            urlPatterns = Collections.emptySet();
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String servletPath = request.getServletPath();
        String context = request.getContextPath();
        if(isMatches(servletPath)){
            request.getRequestDispatcher(context + "/" + rewriteTo).forward(servletRequest,servletResponse);
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }

    private boolean isMatches(String url){
        if(CollectionUtils.isEmpty(urlPatterns)){
            return false;
        }
        for(String str : urlPatterns){
            if(str.endsWith("/*")){
                String startStr = str.substring(0,str.length() - 2);
                if(url.startsWith(startStr)){
                    return true;
                }
            }
            Pattern pattern = Pattern.compile(str);
            if(pattern.matcher(url).matches()){
                return true;
            }
        }
        return false;
    }
}
