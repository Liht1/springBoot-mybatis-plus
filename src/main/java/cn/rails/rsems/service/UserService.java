package cn.rails.rsems.service;

import cn.rails.rsems.model.User;

import java.util.List;

/**
 * Created by tao on 12/3/17.
 */
public  interface UserService {
    Object selectUser(Integer page, Integer size);

    List<User> findUserInfo();
}
