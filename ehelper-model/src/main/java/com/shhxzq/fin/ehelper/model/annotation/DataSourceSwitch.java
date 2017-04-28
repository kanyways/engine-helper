package com.shhxzq.fin.ehelper.model.annotation;

import java.lang.annotation.*;

/**
 * 在方法上加此注解，会使用第一个参数即DataSource枚举切换数据源
 *
 * @author kangyonggan
 * @since 2016/12/8
 */
@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSourceSwitch {

}
