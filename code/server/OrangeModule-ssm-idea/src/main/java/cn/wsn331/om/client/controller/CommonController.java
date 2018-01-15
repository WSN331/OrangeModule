package cn.wsn331.om.client.controller;

import cn.wsn331.om.console.common.Constants;
import cn.wsn331.om.console.service.UserLoginService;
import cn.wsn331.om.model.User;
import cn.wsn331.om.model.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import shit.helper.security.MD5Util;
import shit.ssm1.mvc.BaseController;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonController extends BaseController {

    @Autowired
    UserLoginService userLoginService;

    protected String createToken(User user) {
        SimpleDateFormat format = new SimpleDateFormat(Constants.DATETIME_FORMAT_MILL_NOSPACE);
        Date now = new Date();
        String code = user.getAccount() + format.format(now);
        UserLogin userLogin = new UserLogin();
        userLogin.setUserId(user.getId());
        userLogin.setCreateTime(now);
        userLogin.setAccessToken(MD5Util.getMD5(code));
        userLoginService.insert(userLogin);
        return userLogin.getAccessToken();
    }

    /**
     * 判断用户的token是否正确
     * @param userId
     * @param accessToken
     * @return
     */
    protected boolean isTokenTrue(Integer userId, String accessToken) {
        UserLogin userLogin = userLoginService.findByUserId(userId);
        return userLogin == null ? false : userLogin.getAccessToken().equals(accessToken);
    }
}
