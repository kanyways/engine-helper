package com.shhxzq.fin.ehelper.biz.aop;

import com.shhxzq.fin.ehelper.biz.util.MultiDataSource;
import com.shhxzq.fin.ehelper.model.annotation.DataSourceSwitch;
import com.shhxzq.fin.ehelper.model.constants.DataSource;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author kangyonggan
 * @since 4/28/17
 */
@Log4j2
@Component
@Aspect
public class DataSourceAop {

    @Pointcut("execution(* com.shhxzq.fin.ehelper.biz.service.impl..*.*(..))")
    public void pointcut() {
    }

    /**
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object args[] = joinPoint.getArgs();
        Class clazz = joinPoint.getTarget().getClass();

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = clazz.getMethod(methodSignature.getName(), methodSignature.getParameterTypes());

        DataSourceSwitch dataSourceSwitch = method.getAnnotation(DataSourceSwitch.class);
        if (dataSourceSwitch != null) {
            log.info("使用指定的数据源.");
            if (args.length > 0) {
                Object obj = args[0];
                if (obj instanceof DataSource) {
                    DataSource dataSource = (DataSource) obj;
                    MultiDataSource.setDataSource(dataSource);
                    log.info("数据源：{}", dataSource.name());
                } else {
                    log.info("第一个参数不是DataSource枚举，所以仍然使用默认数据源.");
                }
            } else {
                log.info("第一个参数不是DataSource枚举，所以仍然使用默认数据源.");
            }
        } else {
            log.info("使用默认数据源.");
        }


        return joinPoint.proceed(args);
    }
}