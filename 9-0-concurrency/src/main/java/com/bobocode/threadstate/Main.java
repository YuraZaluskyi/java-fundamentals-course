package com.bobocode.threadstate;
import lombok.SneakyThrows;
public class Main {
  private static String monitor = new String("monitor");
  @SneakyThrows
  public static void main(String[] args) {
    Thread t1 = new Thread(() -> {
      try {synchronized (monitor) {monitor.wait();}
        Thread.sleep(5);
        synchronized (monitor) {}
      } catch (InterruptedException e) {e.printStackTrace();}});
    System.out.println(t1.getName() + " " + t1.getState());
    t1.start();
    System.out.println(t1.getName() + " " + t1.getState());
    System.out.println(t1.getName() + " " + t1.getState());
    synchronized (monitor) {monitor.notifyAll();}

    synchronized (monitor) {Thread.sleep(1);}
    System.out.println(t1.getName() + " " + t1.getState());
    t1.join();
    System.out.println(t1.getName() + " " + t1.getState());}}