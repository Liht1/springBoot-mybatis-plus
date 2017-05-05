package cn.rails.rsems.controller;

import cn.rails.rsems.common.action.BaseAction;
import cn.rails.rsems.common.vo.JsonResult;
import  cn.rails.rsems.service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by tao on 12/3/17.
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/user")
public class RestController extends BaseAction{
    private static final Logger logger = LogManager.getLogger(RestController.class);

     @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public JsonResult test(Integer page,Integer size) {
      logger.info("查询初始化--------------------");
      try {
        return buildJsonResult(userService.selectUser(page,size),true,"2014","查询用户成功！");
      }catch (Exception e){
        return buildJsonResult(null,false,"2014","查询用户成功！");
      }


        //return userService.selectUser(page,size);
    }



  @RequestMapping("/find")
  public JsonResult find(Integer page,Integer size) {
    logger.info("查询初始化--------------------");
    try {
      return buildJsonResult(userService.findUserInfo(),true,"2014","查询用户成功！");
    }catch (Exception e){
      return buildJsonResult(null,false,"2014","查询用户成功！");
    }


    //return userService.selectUser(page,size);
  }


}
