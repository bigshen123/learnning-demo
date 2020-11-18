package com.bigshen.chatDemoService.concurrent.synchronize;

public class Accounting implements Runnable {

  static Accounting instance = new Accounting();
  static int i = 0;

  public void run() {
    for (int j = 0; j < 10000; j++) {
      synchronized (instance) {
        i++;
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    //create
    Thread t1 = new Thread(instance);
    Thread t2 = new Thread(instance);
    Thread t3 = new Thread(instance);
    Thread t4 = new Thread(instance);
    Thread t5 = new Thread(instance);
    Thread t6 = new Thread(instance);
    Thread t7 = new Thread(instance);
    Thread t8 = new Thread(instance);
    Thread t9 = new Thread(instance);
    //start
    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();
    t6.start();
    t7.start();
    t8.start();
    t9.start();
//join
    t1.join();
    t2.join();
    t3.join();
    t4.join();
    t5.join();
    t6.join();
    t7.join();
    t8.join();
    t9.join();
    System.out.println(i);
  }
}


