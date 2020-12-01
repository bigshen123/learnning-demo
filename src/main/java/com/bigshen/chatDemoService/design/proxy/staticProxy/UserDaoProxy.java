package com.bigshen.chatDemoService.design.proxy.staticProxy;

/**
 * @ClassName UserDaoProxy
 * @Description:TODO 使用静态代理
 * @Author: byj
 * @Date: 2020/12/1
 */
public class UserDaoProxy extends UserDao {
    private UserDao userDao;

    public UserDaoProxy(UserDao userDao){
        this.userDao=userDao;
    }

    public void save(){
        System.out.println("开启事务......");
        userDao.save();
        System.out.println("关闭事务......");
    }

    public static void main(String[] args) {
        UserDao userDao=new UserDao();
        UserDaoProxy userDaoProxy=new UserDaoProxy(userDao);
        userDaoProxy.save();
    }
}
