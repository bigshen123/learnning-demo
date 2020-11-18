package com.bigshen.chatDemoService.design.abstractFactory;

/**
 * @Description:
 * @Author: byj
 * @Date: 2019/12/3 14:34
 */
public class Red implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}