package cn.wsn331.om.client.controller;

import cn.wsn331.om.console.service.UserService;
import cn.wsn331.om.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shit.helper.ShitJSONHelper;
import shit.ssm1.mvc.BaseController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author GongTengPangYi
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    UserService userService;

    @RequestMapping("/doTest")
    public void doTest(@RequestParam("userId")Integer userId, HttpServletResponse response) throws IOException {
        User user = userService.selectByPrimaryKey(userId);
        System.out.println(user);
        response.getWriter().print(ShitJSONHelper.fromObject(user, "* !createTime"));
    }

}
