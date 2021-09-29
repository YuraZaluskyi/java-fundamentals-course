package com.bobocode.deadlock;

import static java.lang.Thread.sleep;

import lombok.SneakyThrows;

public class Main {


  @SneakyThrows
  public static void main(String[] args) {
    String monitor1 = new String("monitor");
    String monitor2 = new String("monitor");
    Thread t1 = new Thread(() -> {
      synchronized (monitor1) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        synchronized (monitor2) {
        }
      }
    });

    Thread t2 = new Thread(() -> {
      synchronized (monitor2) {
        synchronized (monitor1) {
        }
      }
    });

    Thread t3 = new Thread(() -> {
      while (true) {
        System.out.println(t1.getState());
        System.out.println(t2.getState());
        try {
          sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });
    t3.start();
    t1.start();
    t2.start();
    t1.join();
    t2.join();
  }
}
