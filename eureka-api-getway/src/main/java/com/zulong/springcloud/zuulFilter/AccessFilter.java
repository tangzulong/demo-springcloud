package com.zulong.springcloud.zuulFilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tangzulong
 * @file AccessFilter.java
 * @date 2018-01-19
 * 10:20
 */
@Component
public class AccessFilter extends ZuulFilter{

    private Logger logger= LoggerFactory.getLogger(AccessFilter.class);


    /**
     * filterType代表过滤类型
     *PRE: 该类型的filters在Request routing到源web-service之前执行。用来实现Authentication、选择源服务地址等（前置过滤）
     * ROUTING：该类型的filters用于把Request routing到源web-service，源web-service是实现业务逻辑的服务。这里使用HttpClient请求web-service。
     * POST：该类型的filters在ROUTING返回Response后执行。用来实现对Response结果进行修改，收集统计数据以及把Response传输会客户端。(后置过滤)
     * ERROR：上面三个过程中任何一个出现错误都交由ERROR类型的filters进行处理。（异常过滤）
     * @return
     */
    @Override
    public String filterType() {
        //前置过滤器
        return "pre";
    }

    /**
     *代表过滤器的顺序
     * @return
     */
    @Override
    public int filterOrder() {
        //数字越大优先级越低
        return 0;
    }

    /**
     * 代表过滤是否生效（可动态决定这个filter是否生效）
     * @return
     */
    @Override
    public boolean shouldFilter() {
        //true生效  false失效
        return true;
    }

    /**
     * 主要用于权限控制、日志管理 token验证
     * @return
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        logger.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

        //获取传来的参数accessToken
        Object accessToken = request.getParameter("accessToken");
        accessToken="aa";
        if(accessToken == null) {
            logger.warn("access token is empty");
            //过滤该请求，不往下级服务去转发请求，到此结束
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("{\"result\":\"accessToken为空!\"}");
            ctx.getResponse().setContentType("text/html;charset=UTF-8");
            return null;
        }
        //如果有token，则进行路由转发
        logger.info("access token ok");
        //这里return的值没有意义，zuul框架没有使用该返回值
        return null;
    }
}
