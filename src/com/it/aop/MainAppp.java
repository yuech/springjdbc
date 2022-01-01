package com.it.aop;

import com.it.aop.pojo.Users;
import com.it.aop.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainAppp {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = app.getBean(UserService.class);
        Users u = new Users();
        u.setAge(20);
        u.setPwd("123456");
        u.setUserName("spring111");
        userService.addUser(u);
       /* Users u = userService.getUsersById(1);
        System.out.println(u);*/
       /* List<Users> users = userService.getUsers();
        System.out.println(users);*/
       /* userService.zhuanzhang(1,2,100);*/
    }
}
