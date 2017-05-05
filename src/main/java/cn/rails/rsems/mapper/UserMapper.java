package cn.rails.rsems.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import cn.rails.rsems.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * Created by tao on 12/3/17.
 */

public interface UserMapper extends BaseMapper<User> {

   List<User> selectMyPage(RowBounds rowBounds, @Param("ew") Wrapper<User> wrapper, User user);
   public   List<User> findUserInfo(User user);
   //public   List<CompanyTypeCompanyDto> findListAll();

}