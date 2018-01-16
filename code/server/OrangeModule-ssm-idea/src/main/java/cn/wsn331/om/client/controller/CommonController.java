package cn.wsn331.om.client.controller;

import cn.wsn331.om.console.common.Constants;
import cn.wsn331.om.console.service.ConfigService;
import cn.wsn331.om.console.service.UserLoginService;
import cn.wsn331.om.model.User;
import cn.wsn331.om.model.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import shit.helper.ShitFileHelper;
import shit.helper.security.MD5Util;
import shit.ssm1.mvc.BaseController;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonController extends BaseController {

    public static final String WWW_ROOT = "www_root";
    public static final String WWW_ROOT_WIN = "www_root_win";

    @Autowired
    UserLoginService userLoginService;

    @Autowired
    ConfigService configService;

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

    /**
     * 获取图片的Base64
     * @param name 图片名
     * @return
     */
    protected String getImageBase64ByName(String name) {
        return ShitFileHelper.encode(ShitFileHelper.read(getImageUrl(name)));
    }

    /**
     * 存储图片
     * @param fileName
     * @param base64
     * @return
     */
    protected String saveImageBase64(String fileName, String base64) {
        String name = fileName + "/" + new SimpleDateFormat(Constants.DATETIME_FORMAT_MILL_NOSPACE).format(new Date());
        if (ShitFileHelper.write(ShitFileHelper.decode(base64), getImageUrl(name))) {
            return name;
        }
        return null;
    }

    /**
     * 获取图片路径
     * @param fileName
     * @return
     */
    protected String getImageUrl(String fileName) {
        String wwwRootKey = isWindows() ? WWW_ROOT_WIN : WWW_ROOT;
        return configService.findByKey(wwwRootKey).getValue() + "/images/" + fileName;
    }

    /**
     * 判断是否为windows
     * @return
     */
    protected boolean isWindows() {
        boolean flag = false;
        if (System.getProperties().getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1) {
            flag = true;
        }
        return flag;
    }
}
