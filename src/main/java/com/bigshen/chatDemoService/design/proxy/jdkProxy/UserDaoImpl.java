package com.bigshen.chatDemoService.design.proxy.jdkProxy;

import com.bigshen.chatDemoService.concurrent.hashmap.User;

/**
 * @ClassName UserDaoImpl
 * @Description:TODO
 * @Author: byj
 * @Date: 2020/12/1
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("�������ݵķ���......");
    }
}
