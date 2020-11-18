package com.bigshen.chatDemoService.concurrent.thread.chap1;

public class Demo16 {
    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        System.out.println("ÊÇ·ñÍ£Ö¹1£¿" + Thread.interrupted());
        System.out.println("ÊÇ·ñÍ£Ö¹2£¿" + Thread.interrupted());
    }
}
