package com.bigshen.chatDemoService.design.singlton;

/**
 * @Description:
 * @Author: BIGSHEN
 * @Date: 2019/12/13 10:56
 */
public class Singlton {
    private static volatile Singlton singlton;

    private Singlton() {

    }

    private static synchronized Singlton getInstance() {
        if (singlton == null) {
            singlton = new Singlton();
        }
        return  singlton;
    }
}
