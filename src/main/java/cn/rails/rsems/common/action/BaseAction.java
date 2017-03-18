
package cn.rails.rsems.common.action;

import cn.rails.rsems.common.json.JSONOuter;
import cn.rails.rsems.common.vo.JsonResult;
import com.alibaba.fastjson.JSONException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 控制层基类
 * @ClassName: BaseAction
 * @Description: BaseAction工具类
 * @author 李海涛
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked","unused" })
public class BaseAction {
	private Logger logger = LoggerFactory.getLogger(BaseAction.class);
	
	protected HttpServletRequest request;
	
    protected HttpServletResponse response;
    
    protected HttpSession session;
     
    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){
        this.request = request; 
        this.response = response; 
        this.session = request.getSession(); 
    } 
    
	public <T> JsonResult buildJsonResult(T obj){
        return new JsonResult(obj,true,"ok");
    }
	
	public <T> JsonResult buildJsonResult(T obj, String code){
        return new JsonResult(obj, code);
    }
	
	public <T> JsonResult buildJsonResult(T obj, String code, String message){
        return new JsonResult(obj, code, message);
    }
	
	public <T> JsonResult buildJsonResult(T obj,Boolean success, String code, String message){
        return new JsonResult(obj,success, message, code);
    }
	
	public <T> void buildJsonResultAndWrite(T obj){
		JsonResult jsonResult = new JsonResult(obj,true,"ok");
         try {
			JSONOuter.write(response.getWriter(), jsonResult);
		} catch (IOException e) {
			throw new JSONException(e.getMessage(), e);
		}
    }
	
	public <T> void buildJsonResultAndWrite(T obj, String code){
		JsonResult jsonResult = new JsonResult(obj, code);
		try {
			JSONOuter.write(response.getWriter(), jsonResult);
		} catch (IOException e) {
			throw new JSONException(e.getMessage(), e);
		}
    }
	
	public <T> void buildJsonResultAndWrite(T obj, String code, String message){
		JsonResult jsonResult = new JsonResult(obj, code, message);
		try {
			JSONOuter.write(response.getWriter(), jsonResult);
		} catch (IOException e) {
			throw new JSONException(e.getMessage(), e);
		}
    }
	
	public <T> void buildJsonResultAndWrite(T obj,Boolean success, String code, String message){
		JsonResult jsonResult = new JsonResult(obj,success, code, message);
		try {
			JSONOuter.write(response.getWriter(), jsonResult);
		} catch (IOException e) {
			throw new JSONException(e.getMessage(), e);
		}
    }
	
	/**
     * 获取客户端真实IP地址
     *
     * @return IP
     */
    public String getClientIp() {
        String ip = request.getHeader("x-forwarded-for");
        if (isUnAvailableIp(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (isUnAvailableIp(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (isUnAvailableIp(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
	
	/**
     * 获取客户端真实IP地址
     *
     * @param request HttpServletRequest
     * @return IP
     */
    public String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (isUnAvailableIp(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (isUnAvailableIp(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (isUnAvailableIp(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    private static boolean isUnAvailableIp(String ip) {
        return (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip));
    }
}
