package com.suixingpay.monkey.admin.service.bean;

import java.util.List;

/**
 * Created by Evan Xu on 31/3/2017.
 */


public class Navigation {

    private Type type;
    private List<Item> itemList;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
