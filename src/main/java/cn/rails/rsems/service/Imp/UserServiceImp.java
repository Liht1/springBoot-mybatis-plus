package cn.rails.rsems.service.Imp;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import cn.rails.rsems.mapper.UserMapper;
import cn.rails.rsems.service.UserService;
import cn.rails.rsems.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tao on 12/3/17.
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    public Page<User> selectUser(Integer page,Integer size){
        Page<User> userPage = new Page<>(page,size);
        User user= new User();
        userPage.setRecords(userMapper.selectPage(
                userPage,new EntityWrapper<User>().eq("user_name","123")
                ));
//        user.setPwd("123");
//        userPage.setRecords(
//                userMapper.selectMyPage(
//                        userPage,
//                        new EntityWrapper<User>(), user));

       // User  user =null;



        return userPage;
    }

   public  List<User>findUserInfo(){

            User  user = new User();
            user.setPwd("123");

        return  userMapper.findUserInfo(user);
    };


    @Transactional
    public void insertUser() {
        User user = new User();
        user.setId(1000);
        user.setName("1");
        user.setPwd("1");
        userMapper.insert(user);
    }

}
