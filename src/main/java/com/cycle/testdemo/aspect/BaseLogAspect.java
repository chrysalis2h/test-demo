package com.cycle.testdemo.aspect;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 *  * @ClassName: SysLogAspect
 *  * @Description: SysLogAspect
 *  * @Author: HeJin
 *  * @Date: 2019\12\20 0020 15:18
 *  * @Version: v1.0 文件初始创建
 */
public class BaseLogAspect {

    // 调用hutool-log
    private static final Log logger = LogFactory.get();

    private static ThreadLocal<Long> startTime = new ThreadLocal<>();

    public void doBefore(JoinPoint joinPoint) throws Throwable {
        logger.info("============================doBefore============================");
        startTime.set(System.currentTimeMillis());

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //记录请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        logger.info("============================doAround-start============================");
        long beginTime = System.currentTimeMillis();
        Object result = point.proceed();
        long time = System.currentTimeMillis() - beginTime;
        logger.info("============================doAround-end============================");
        return result;
    }

    public void doAfter(JoinPoint jointPoint) throws Throwable {
        logger.info("============================doAfter============================");
    }

    public void doAfterReturning(Object ret) throws Throwable {
        logger.info("============================doAfterReturning============================");
        // 处理完请求，返回内容
        logger.info("RESPONSE : [{}]", JSON.toJSONString(ret));
        logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
    }

    public void doAfterThrowing(JoinPoint jointPoint, Throwable e) throws Throwable {
        logger.info("============================doAfterThrowing============================");
    }
}
