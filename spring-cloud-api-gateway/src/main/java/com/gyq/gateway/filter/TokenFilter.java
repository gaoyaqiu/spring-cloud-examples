package com.gyq.gateway.filter;

import com.google.common.base.Strings;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * token 过滤器.
 *
 * @author gaoyaqiu
 */
public class TokenFilter extends ZuulFilter {

    private final Logger logger = LoggerFactory.getLogger(TokenFilter.class);

    /**
     * 在请求被路由之前调用 .
     *
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     * @return 返回一个字符串代表过滤器的类型
     */
    @Override
    public String filterType() {
        logger.info("TokenFilter filterType in.....");
        return "pre";
    }

    /**
     * filter执行顺序，数字越小，优先级越高
     *
     * @return
     */
    @Override
    public int filterOrder() {
        logger.info("TokenFilter filterOrder in.....");
        return 0;
    }

    /**
     * 是否执行该过滤器配置（true: 需要过滤）.
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        logger.info("TokenFilter shouldFilter in.....");
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        logger.info("--->>> TokenFilter {},{}", request.getMethod(), request.getRequestURL().toString());

        String token = request.getParameter("token");

        if (!Strings.isNullOrEmpty(token)) {
            // 对请求进行路由
            ctx.setSendZuulResponse(true);
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess", true);
            return null;
        } else {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(400);
            ctx.setResponseBody("token is empty");
            ctx.set("isSuccess", false);
            return null;
        }
    }
}
