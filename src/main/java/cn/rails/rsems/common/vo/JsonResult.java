package cn.rails.rsems.common.vo;

import com.fasterxml.jackson.annotation.JsonView;
import org.apache.log4j.Logger;

import java.io.Serializable;

/**
 * web前端json数据处理类
 * @author 李海涛
 */
public class JsonResult<T> implements Serializable {
    public static interface ErrorView {}
    public static interface NormalView extends ErrorView {}
    /**
     *
     */
    private static final long serialVersionUID = 3863559687276427577L;

    @JsonView(ErrorView.class)
    private boolean success = true;

    @JsonView(NormalView.class)
    private T data;//数据

    @JsonView(NormalView.class)
    private String secure;//安全数据

    @JsonView(ErrorView.class)
    private String code;//返回给调用者的错误码（如：100001）

    @JsonView(ErrorView.class)
    public String message;

	public JsonResult() {
    }

	public JsonResult(T data, String code) {
        // TODO Auto-generated constructor stub
        this.data = data;
        this.code = code;
    }

    public JsonResult(T data, Boolean success, String message) {
        // TODO Auto-generated constructor stub
        this.data = data;
        this.success = success;
        this.message = message;
    }

    public JsonResult(T data, String code, String message) {
        // TODO Auto-generated constructor stub
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public JsonResult(T data, Boolean success, String message, String code) {
        // TODO Auto-generated constructor stub
        this.data = data;
        this.success = success;
        this.message = message;
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static <T> JsonResult<T> newResult() {

        return new JsonResult<T>();
    }

    public String getSecure() {
        return secure;
    }

    public void setSecure(String secure) {
        this.secure = secure;
    }

    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
