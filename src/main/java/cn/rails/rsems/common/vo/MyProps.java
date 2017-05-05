package cn.rails.rsems.common.vo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by macAdministrator on 2017/3/30.
 */
@Component
@ConfigurationProperties(prefix="myProps")
public class MyProps {
  private List<String> userUrl = new ArrayList<>();
  private List<String> notUrl = new ArrayList<>();
  private List<Map<String, String>> listProp1 = new ArrayList<>(); //接收prop1里面的属性值

  public List<Map<String, String>> getListProp1() {
    return listProp1;
  }
  public List<String> getUserUrl() {
    return userUrl;
  }

  public List<String> getNotUrl() {
    return notUrl;
  }



}
