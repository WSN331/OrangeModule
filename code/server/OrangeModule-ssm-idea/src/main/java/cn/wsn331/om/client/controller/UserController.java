package cn.wsn331.om.client.controller;

import cn.wsn331.om.console.service.UserService;
import cn.wsn331.om.model.User;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import shit.helper.ShitJSONHelper;
import shit.helper.ShitReflectException;
import shit.helper.ShitReflectHelper;
import shit.helper.json.ShitJSONObject;
import shit.helper.json.netsf.ShitJSONObjectByNetSf;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @author GongTengPangYi
 */
@Controller
@RequestMapping("/user")
public class UserController extends CommonController{

    /**
     * 初始化leanCloud的一些参数和API
     */
    public static final String AVOS_APP_ID = "STPGnhizp1AvCx1veJCsN6qx-gzGzoHsz";
    public static final String AVOS_CID = "gAMD5nvfI2ajuRh8vKTLkM5n";
    public static final String AVOS_MASTER_KEY = "7B8r7ADJn0E7Nkvep26x8jzI";
    static {
        AVOSCloud.initialize(AVOS_APP_ID, AVOS_CID, AVOS_MASTER_KEY);
    }

    /**
     * 默认的图片
     */
    public static final String DEFAULT_IMAGE = "default.jpg";

    @Autowired
    UserService userService;

    /**
     * 登录
     * @param account 账号
     * @param verifyCode 密码
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam("account")String account, @RequestParam("verifyCode")String verifyCode) {
        ShitJSONObject<?> jobj = new ShitJSONObjectByNetSf();
        int loginResult = -1;// 0为成功，1为验证码错误，2为账号已登录
        User user = userService.findByAccount(account);
        if (verifyCode == null) {
            loginResult = 1;
        } else if (user != null && userLoginService.findByUserId(user.getId()) != null) {
            loginResult = 2;
        } else {
            try {
                AVOSCloud.verifySMSCode(verifyCode, account);
                if (user == null) {
                    user = new User();
                    user.setAccount(account);
                    user.setCreateTime(new Date());
                    user.setIcon(DEFAULT_IMAGE);
                    userService.insert(user);
                    user = userService.findByAccount(account);
                }
                ShitJSONObject<?> userJSON = ShitJSONHelper.fromObject(user, "* !password !state !icon");
                userJSON.put("accessToken", createToken(user));
                userJSON.put("icon", getImageBase64ByName(user.getIcon()));
                jobj.put("user", userJSON);
                loginResult = 0;
            } catch (AVException e) {
                e.printStackTrace();
                loginResult = 1;
            }
        }
        jobj.put("loginResult", loginResult);
        return jobj.toString();
    }

    /**
     * 发送验证码
     * @param phone 手机号
     * @return 是否发送成功
     */
    @RequestMapping("/sendVerify")
    @ResponseBody
    public String sendVerify(@RequestParam("phone")String phone) {
        ShitJSONObject<?> jobj = new ShitJSONObjectByNetSf();
        int sendVerifyResult = 1;// 0为成功, 1为失败
        try {
            AVOSCloud.requestSMSCode(phone, "SmsDemo", "验证", 10);
            sendVerifyResult = 0;
        } catch (AVException e) {
            jobj.put("message", e.getMessage());
        }
        jobj.put("sendVerifyResult", sendVerifyResult);
        return jobj.toString();
    }

    /**
     * 注销
     * @param userId 用户ID
     * @param accessToken 令牌
     * @return
     */
    @RequestMapping("/logout")
    @ResponseBody
    public String logout(@RequestParam("userId")Integer userId, @RequestParam("accessToken")String accessToken) {
        ShitJSONObject<?> jobj = new ShitJSONObjectByNetSf();
        int logoutResult = 1;// 0为成功, 1为失败
        if (isTokenTrue(userId, accessToken)) {
            userLoginService.deleteByUserId(userId);
            logoutResult = 0;
        }
        jobj.put("logoutResult", logoutResult);
        return jobj.toString();
    }

    /**
     * 完善信息
     * @param userId
     * @param accessToken
     * @param request
     * @return
     */
    @RequestMapping("/complete")
    @ResponseBody
    public String complete(@RequestParam("userId")Integer userId, @RequestParam("accessToken")String accessToken, HttpServletRequest request) {
        ShitJSONObject<?> jobj = new ShitJSONObjectByNetSf();
        int completeResult = 2;// 0为成功, 1为未登录，2为未知错误
        String keyStr = "nickname,name,createTime,";
        if (isTokenTrue(userId, accessToken)) {
            User user = userService.selectByPrimaryKey(userId);
            if (user != null) {
                Map<String, String[]> params = request.getParameterMap();
                for (String key : params.keySet()) {
                    String value = params.get(key)[0];
                    if (keyStr.indexOf(key + ",") > -1 && value != null) {
                        try {
                            ShitReflectHelper.setValue(user, key, value, true);
                        } catch (ShitReflectException e) {
                            e.printStackTrace();
                        }
                    } else if (key.equals("icon")) {
                        user.setIcon(saveImageBase64("user/" + userId,value));
                    }
                }
                userService.updateByPrimaryKey(user);
                completeResult = 0;
            }
        } else {
            completeResult = 1;
        }
        jobj.put("completeResult", completeResult);
        return jobj.toString();
    }

}
