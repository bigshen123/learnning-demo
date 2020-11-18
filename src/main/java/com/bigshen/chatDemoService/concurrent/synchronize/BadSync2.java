package com.bigshen.chatDemoService.concurrent.synchronize;

public class BadSync2 implements Runnable {

  static Integer i = 0;

  public synchronized void increase() {
    i++;
  }

  public void run() {
    for (int j = 0; j < 10000; j++) {
      increase();
    }
  }

  /**
   * 错误! 无法控制，因为出现了2个实例 解决方法： 1 使用static synchronzed 2 使用一个Runnable实例
   */
  public static void main(String[] args) throws InterruptedException {
    BadSync2 bad1 = new BadSync2();
    BadSync2 bad2 = new BadSync2();
    BadSync2 bad3 = new BadSync2();
    BadSync2 bad4 = new BadSync2();
    BadSync2 bad5 = new BadSync2();
    Thread t1 = new Thread(bad1);
    Thread t2 = new Thread(bad2);
    Thread t3 = new Thread(bad3);
    Thread t4 = new Thread(bad4);
    Thread t5 = new Thread(bad5);
    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();
    t1.join();
    t2.join();
    t3.join();
    t4.join();
    t5.join();
    System.out.println(i);
  }
}

