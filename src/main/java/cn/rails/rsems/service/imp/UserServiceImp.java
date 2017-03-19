package cn.rails.rsems.service.imp;

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
//      user.setPwd("123");
      userPage.setAsc(false);
      EntityWrapper ew= new EntityWrapper(user);
      ew.setEntity(user);
      ew.andNew("pwd=123");

      ew.like("name","我");
        userPage.setRecords(userMapper.selectPage(
                userPage,ew
                ));
        System.out.println(ew.getSqlSegment());
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
        user.setName("我是最酷的！！");
        user.setPwd("123");
        userMapper.insert(user);
    }

}
