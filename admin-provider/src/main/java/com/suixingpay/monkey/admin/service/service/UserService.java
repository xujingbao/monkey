package com.suixingpay.monkey.admin.service.service;

import com.suixingpay.monkey.admin.service.bean.User;

import java.util.List;

/**
 * Created by Evan Xu on 20/3/2017.
 */
public interface UserService {
    /**
     * @return
     */
    List<User> getUserList();

    /**
     * @param id
     * @return
     */
    User getUser(String id);

    /**
     * @param user
     * @return
     */
    String addUser(User user);

    /**
     * @param user
     * @return
     */
    String updateUser(User user);

    /**
     * @param id
     * @return
     */
    String deleteUser(String id);
}
