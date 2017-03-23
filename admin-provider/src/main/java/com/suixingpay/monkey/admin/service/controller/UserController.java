package com.suixingpay.monkey.admin.service.controller;

import com.suixingpay.monkey.admin.service.bean.User;
import com.suixingpay.monkey.admin.service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created By Evan Xu on 2017/3/15.
 */
@RestController
@RequestMapping("/v1/users")
public class UserController {
    //
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    /**
     * 处理"/users/"的GET请求，用来获取用户列表
     * 还可以通过RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList() {
        logger.info("getUserList success");
        return userService.getUserList();
    }

    /**
     * 处理"/users/"的POST请求，用来创建User
     * 除了ModelAttribute绑定参数之外，还可以通过RequestParam从页面中传递参数
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addUser(@ModelAttribute User user) {
        logger.info("addUser {}", user);
        userService.addUser(user);
        logger.info("addUser success");
        return "success";
    }

    /**
     * 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
     * url中的id可通过PathVariable绑定到函数的参数中
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable String id) {
        logger.info("getUser begin");
        User user = userService.getUser(id);
        logger.info("getUser {} success", user);
        return user;
    }

    /**
     * 处理"/users/{id}"的PUT请求，用来更新User信息
     *
     * @param id
     * @param user
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateUser(@PathVariable String id, @ModelAttribute User user) {
        logger.info("updateUser {} begin", user);
        userService.updateUser(user);
        logger.info("updateUser success");
        return "success";
    }

    /**
     * 处理"/users/{id}"的DELETE请求，用来删除User
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable String id) {
        logger.info("deleteUser {} begin", id);
        userService.deleteUser(id);
        logger.info("deleteUser success");
        return "success";
    }
}
