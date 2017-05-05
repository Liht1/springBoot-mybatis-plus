package cn.rails.rsems.common.interceptor.web;

import cn.rails.rsems.common.interceptor.LoginInterceptor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by macAdministrator on 2017/3/30.
 */
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
  @Override
  public void addInterceptors(InterceptorRegistry registry) {

    // 多个拦截器组成一个拦截器链

    // addPathPatterns 用于添加拦截规则

    // excludePathPatterns 用户排除拦截

    registry.addInterceptor(new LoginInterceptor());

  //  registry.addInterceptor(new LoginInterceptor()).excludePathPatterns("/user/test");

   // registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**");

    super.addInterceptors(registry);

  }


}
