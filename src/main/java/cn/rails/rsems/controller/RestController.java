package cn.rails.rsems.controller;

import cn.rails.rsems.common.action.BaseAction;
import cn.rails.rsems.common.vo.JsonResult;
import  cn.rails.rsems.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by tao on 12/3/17.
 */
@org.springframework.web.bind.annotation.RestController

public class RestController extends BaseAction{
    private static final Logger logger = LoggerFactory.getLogger(RestController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("test")
    public JsonResult test(Integer page, Integer size) {

        logger.info("查询初始化--------------------");
        return buildJsonResult(userService.findUserInfo());

        //return userService.selectUser(page,size);
    }


}
