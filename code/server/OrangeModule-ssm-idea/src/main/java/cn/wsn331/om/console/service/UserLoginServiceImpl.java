package cn.wsn331.om.console.service;

import cn.wsn331.om.console.mapper.UserLoginMapper;
import cn.wsn331.om.model.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shit.ssm1.mybatis.BaseMapper;
import shit.ssm1.mybatis.BaseServiceImpl;

@Service("userLoginService")
public class UserLoginServiceImpl extends BaseServiceImpl<UserLogin, Integer> implements UserLoginService {

    @Autowired
    UserLoginMapper userLoginMapper;

    @Override
    public UserLogin findByUserId(Integer userId) {
        return userLoginMapper.selectByUserId(userId);
    }

    @Override
    public UserLogin findByAccessToken(String accessToken) {
        return userLoginMapper.selectByAccessToken(accessToken);
    }

    @Override
    public void deleteByUserId(Integer userId) {
        userLoginMapper.deleteByUserId(userId);
    }

    @Override
    public BaseMapper<UserLogin, Integer> getMapper() {
        return userLoginMapper;
    }
}
