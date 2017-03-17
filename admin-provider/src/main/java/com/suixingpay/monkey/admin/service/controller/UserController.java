package com.suixingpay.monkey.admin.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.suixingpay.monkey.admin.service.bean.User;

/**
 * Created By Evan Xu
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 获取用户列表
     *
     * @return
     */
    @RequestMapping("/list")
    public List<User> list(@RequestParam(value = "name", defaultValue = "") String name) {

        //
        List<User> userList = new ArrayList<User>();

        User user = new User();
        user.setName("许景宝");
        user.setSex("1");
        user.setAge("30");
        user.setBirth("19870625");
        user.setAddr("石景山");
        userList.add(user);

        user = new User();
        user.setName("徐华");
        user.setSex("0");
        user.setAge("40");
        user.setBirth("19770625");
        user.setAddr("石景山");
        userList.add(user);

        return userList;
    }

    public User login(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password) {

        return new User("随行付", "123456", "1", "6", "2011", "实兴大街");
    }

}
