package cn.wsn331.om.console.service;

import cn.wsn331.om.console.mapper.UserMapper;
import cn.wsn331.om.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shit.ssm1.mybatis.BaseMapper;
import shit.ssm1.mybatis.BaseServiceImpl;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public BaseMapper<User, Integer> getMapper() {
        return userMapper;
    }

    @Override
    public User findByAccount(String account) {
        return userMapper.selectByAccount(account);
    }
}
