package com.suixingpay.monkey.admin.service.service;

import com.suixingpay.monkey.admin.service.bean.User;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Evan Xu on 20/3/2017.
 */
@Service
public class UserServiceImp implements UserService {

    //
    private static Map<String, User> users = Collections.synchronizedMap(new HashMap<String, User>());

    static {
        User user = new User("1", "随行付", "123456", "0", "6", "2011", "实兴大街");
        users.put(user.getId(), user);
        user = new User("2", "架构部", "123456", "1", "6", "2012", "30号12层");
        users.put(user.getId(), user);
        user = new User("3", "许景宝", "123456", "1", "6", "2016", "西山汇");
        users.put(user.getId(), user);
    }

    @Override
    public List<User> getUserList() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User getUser(String id) {
        return users.get(id);
    }

    @Override
    public String addUser(User user) {
        users.put(user.getId(), user);
        return "success";
    }

    @Override
    public String updateUser(User user) {
        users.put(user.getId(), user);
        return "success";
    }

    @Override
    public String deleteUser(String id) {
        users.remove(id);
        return "success";
    }
}
