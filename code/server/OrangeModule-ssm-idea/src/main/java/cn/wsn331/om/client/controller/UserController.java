package cn.wsn331.om.client.controller;

import cn.wsn331.om.console.service.UserService;
import cn.wsn331.om.model.User;
import cn.wsn331.om.model.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import shit.helper.ShitJSONHelper;
import shit.helper.json.ShitJSONObject;
import shit.helper.json.netsf.ShitJSONObjectByNetSf;
import shit.helper.security.MD5Util;

/**
 * @author GongTengPangYi
 */
@Controller
@RequestMapping("/user")
public class UserController extends CommonController{

    @Autowired
    UserService userService;

    /**
     *
     * @param account
     * @param password
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam("account")String account, @RequestParam("password")String password) {
        ShitJSONObject<?> jobj = new ShitJSONObjectByNetSf();
        int loginResult;// 0为成功，1为账号不存在，2为密码错误,3为已经登录过
        User user = userService.findByAccount(account);
        if (user == null) {
            loginResult = 1;
        } else if (password == null || !(MD5Util.getMD5(password).equals(user.getPassword()))) {
            loginResult = 2;
        } else if (userLoginService.findByUserId(user.getId()) != null) {
            loginResult = 3;
        } else {
            ShitJSONObject<?> userJSON = ShitJSONHelper.fromObject(user, "* !password !state");
            userJSON.put("accessToken", createToken(user));
            jobj.put("user", userJSON);
            loginResult = 0;
        }
        jobj.put("loginResult", loginResult);
        return jobj.toString();
    }

    /**
     *
     * @param account
     * @param password
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestParam("account")String account, @RequestParam("password")String password) {
        ShitJSONObject<?> jobj = new ShitJSONObjectByNetSf();
        int registerResult = 1;// 0为成功，1为账号已存在
        User user = userService.findByAccount(account);
        if (user == null) {
            user = new User();
            user.setAccount(account);
            user.setPassword(MD5Util.getMD5(password));
            userService.insert(user);
            registerResult = 0;
        }
        jobj.put("registerResult", registerResult);
        return jobj.toString();
    }

}
