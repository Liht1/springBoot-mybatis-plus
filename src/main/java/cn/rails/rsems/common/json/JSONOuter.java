/**   
 * @Title: JSONOuter.java 
 * @Package
 * @Copyright: Copyright
 * @author 李海涛
 * @date - 2015-09-28
 * @version V1.0   
 */
package cn.rails.rsems.common.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;

import java.io.Writer;

/**
 * @ClassName: JSONOuter
 * @Description: JSONOuter工具类
 * @author 李海涛
 *
 */
public class JSONOuter {
	
	/**
	 * 向前端写数据
	 * @param out:java.io.Writer对象
	 * @param object:需要写出去的对象
	 */
	public static final void write(Writer out, Object object) {
		JSONSerializer.write(out, object);
    }
	
	/**
	 * 将指定数据格式化为JSON格式
	 * @param object
	 * @return
	 */
	public static final String getJson(Object object) {
		return JSON.toJSONString(object);
    }

	
}
