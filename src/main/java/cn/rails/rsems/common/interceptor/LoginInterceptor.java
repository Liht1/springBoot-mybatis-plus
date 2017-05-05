package cn.rails.rsems.common.interceptor;

/**
 * Created by macAdministrator on 2017/3/30.
 * 拦截器
 * @ClassName: LoginInterceptor
 * @Description: LoginInterceptor拦截器类
 * @author 李海涛
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.rails.rsems.common.vo.MyProps;
import cn.rails.rsems.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements  HandlerInterceptor  {

  @Autowired
  private MyProps  myProps;
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)


    throws Exception {
//    for (String url: myProps.getUserUrl()) {
//      System.out.print(url+"+++++++++++++++++++++");
//    }

    boolean  flag = false;

    String  url = request.getRequestURI().toString();
    String  notUrl = "/user/test";

    if (url.contains(notUrl)){
      flag = true;
    }
    if (!flag){
      Object obj = request.getSession().getAttribute("cur_user");
      System.out.print(url+"+++++++++++++++++++");
      if (obj == null || !(obj instanceof User)) {
        response.sendRedirect(request.getContextPath() + "/login.html");
        return false;
      }
    }
    System.out.println(">>>MyInterceptor1>>>>>>>在请求处理之前进行调用（Controller方法调用之前）");
    return true;// 只有返回true才会继续向下执行，返回false取消当前请求

  }


  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,

                        ModelAndView modelAndView) throws Exception {

    System.out.println(">>>MyInterceptor1>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");

  }


  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)

    throws Exception {

    System.out.println(">>>MyInterceptor1>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
  }


}



