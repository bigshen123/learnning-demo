package com.bigshen.chatDemoService.concurrent.synchronize;

public class StaticSync extends Thread {

  static int i=0;
  public synchronized static void increase(){
    i++;
  }
  public void run() {
    for(int j=0;j<10000;j++){
      increase();
    }
  }

  /**
   * 由于只有一个Runnable实例，因此可以控制线程对i的访问
   */
  public static void main(String[] args) throws InterruptedException {
    StaticSync sync1 = new StaticSync();
    StaticSync sync2 = new StaticSync();
    Thread t1 = new Thread(sync1);
    Thread t2 = new Thread(sync2);
    t1.start();
    t2.start();
    t1.join();
    t2.join();
    System.out.println(i);
  }

}
