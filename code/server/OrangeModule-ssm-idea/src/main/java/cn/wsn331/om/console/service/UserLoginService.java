package cn.wsn331.om.console.service;

import cn.wsn331.om.model.UserLogin;
import shit.ssm1.mybatis.BaseService;

public interface UserLoginService extends BaseService<UserLogin, Integer> {

    UserLogin findByUserId(Integer userId);

    UserLogin findByAccessToken(String accessToken);

    void deleteByUserId(Integer userId);
}
