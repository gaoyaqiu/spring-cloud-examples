package com.gyq.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Password过滤器.
 *
 * @author gaoyaqiu
 */
public class PasswordFilter extends ZuulFilter {

    private final Logger logger = LoggerFactory.getLogger(PasswordFilter.class);


    @Override
    public String filterType() {
        logger.info("PasswordFilter filterType in.....");
        return "post";
    }

    @Override
    public int filterOrder() {
        logger.info("PasswordFilter filterOrder in.....");
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        logger.info("PasswordFilter shouldFilter in.....");
        RequestContext ctx = RequestContext.getCurrentContext();
        // 上一个过滤器验证通过，才会走下面的过滤器处理
        return (boolean) ctx.get("isSuccess");
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        logger.info("--->>> PasswordFilter {},{}", request.getMethod(), request.getRequestURL().toString());

        String username = request.getParameter("password");
        if (null != username && username.equals("123456")) {
            ctx.setSendZuulResponse(true);
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess", true);
            return null;
        } else {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(400);
            ctx.setResponseBody("The password cannot be empty");
            ctx.set("isSuccess", false);
            return null;
        }
    }
}
