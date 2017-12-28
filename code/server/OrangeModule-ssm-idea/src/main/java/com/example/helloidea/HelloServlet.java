package com.example.helloidea;

import com.example.helloidea.bean.User;
import com.example.helloidea.mapper.UserMapper;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloServlet",urlPatterns="/HelloServlet")
public class HelloServlet extends HttpServlet {

    @Resource
    UserMapper userMapper = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().print("Hello Servlet");
//        User user = new User();
//        user.setAccount("xxxxxxxx");
//        user.setPassword("yyyyyyyyy");
//        userMapper.insert(user);
    }
}
