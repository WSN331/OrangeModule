package com.example.helloidea.controller;

import com.example.helloidea.bean.User;
import com.example.helloidea.mapper.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserMapper userMapper;

    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request, Model model){
        System.out.println("xxxxx");
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userMapper.findById(userId);
        System.out.println(user);
        model.addAttribute("user", user);
        return "showUser";
    }
}
