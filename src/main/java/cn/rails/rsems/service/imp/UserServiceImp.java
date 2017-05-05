package cn.rails.rsems.service.imp;

import cn.rails.rsems.model.User;
import org.springframework.stereotype.Service;
import cn.rails.rsems.service.UserService;

import java.util.List;

/**
 * Created by tao on 4/5/17.
 */
@Service
public class UserServiceImp implements UserService {
    @Override
    public Object selectUser(Integer page, Integer size) {
        return null;
    }

    @Override
    public void insertUser() {

    }

    @Override
    public List<User> findUserInfo() {
        return null;
    }
}
