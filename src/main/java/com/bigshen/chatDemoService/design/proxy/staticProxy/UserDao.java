package com.bigshen.chatDemoService.design.proxy.staticProxy;

/**
 * @ClassName UserDao
 * @Description:TODO 原始做法
 * @Author: byj
 * @Date: 2020/12/1
 */
public class UserDao {
    public void save(){
        System.out.println("保存数据的方法.......");
    }

    public static void main(String[] args) {
        UserDao userDao=new UserDao();
        userDao.save();
    }
}
