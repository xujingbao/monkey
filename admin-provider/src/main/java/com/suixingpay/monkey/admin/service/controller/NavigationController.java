package com.suixingpay.monkey.admin.service.controller;

import com.suixingpay.monkey.admin.service.bean.Item;
import com.suixingpay.monkey.admin.service.bean.Navigation;
import com.suixingpay.monkey.admin.service.bean.Type;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evan Xu on 31/3/2017.
 */
@RestController
@RequestMapping("/v1/navs")
public class NavigationController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Navigation> getNavs(){

        Type type = new Type();
        type.setId("1");
        type.setName("架构相关");

        List<Item> itemList = new ArrayList<Item>();
        Item item = new Item();
        item.setName("地址1");
        item.setUrl("http://www.baidu.com");
        itemList.add(item);

        item = new Item();
        item.setName("地址2");
        item.setUrl("http://www.baidu.com");
        itemList.add(item);

        Navigation navigation = new Navigation();
        navigation.setType(type);
        navigation.setItemList(itemList);

        List<Navigation> navs = new ArrayList<Navigation>();
        navs.add(navigation);
        return navs;
    }
}
