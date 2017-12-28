package com.example.helloidea;

import com.example.helloidea.bean.User;
import com.example.helloidea.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestMyBatis {
    @Resource
    private UserMapper userMapper = null;

//  @Before
//  public void before() {
//      ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//      userService = (IUserService) ac.getBean("userService");
//  }

    @Test
    public void test1() {
        User user = new User();
        user.setAccount("xxxxxxxx");
        user.setPassword("yyyyyyyyy");
        userMapper.insert(user);
        user = userMapper.findById(1);
        System.out.println(user);
    }
}