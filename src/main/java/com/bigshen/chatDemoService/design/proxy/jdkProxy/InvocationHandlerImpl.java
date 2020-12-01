package com.bigshen.chatDemoService.design.proxy.jdkProxy;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName InvocationHandlerImpl
 * @Description:TODO JDK动态代理
 * @Author: byj
 * @Date: 2020/12/1
 */
public class InvocationHandlerImpl implements InvocationHandler {

    private Object target;

    public InvocationHandlerImpl(Object target){
        this.target=target;
    }

    /**
     * 动态代理实际运行的方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用开始处理......");
        Object result = method.invoke(target, args);
        System.out.println("调用结束......");
        return result;
    }

    public static void main(String[] args) {
        UserDao userDaoImpl=new UserDaoImpl();
        //被代理对象
        InvocationHandlerImpl invocationHandlerImpl=new InvocationHandlerImpl(userDaoImpl);
        //类加载器
        ClassLoader classLoader = userDaoImpl.getClass().getClassLoader();
        Class<?>[] interfaces = userDaoImpl.getClass().getInterfaces();
        UserDao newProxyInstance = (UserDao) Proxy.newProxyInstance(classLoader, interfaces, invocationHandlerImpl);
        newProxyInstance.save();
    }
}
