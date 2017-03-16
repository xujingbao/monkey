/**
 *
 */
package com.suixingpay.monkey.admin.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.suixingpay.monkey.admin.service.bean.User;

/**
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * @return
     */
    @RequestMapping("/list")
    public List<User> list() {


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

    public User login() {
        return null;
    }

}
