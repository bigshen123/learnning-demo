package com.bigshen.chatDemoService.design.prototype;

/**
 * @Description:圆
 * @Author: byj
 * @Date: 2019/12/3 15:50
 */
public class Circle extends Shape{

    public Circle(){
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }}