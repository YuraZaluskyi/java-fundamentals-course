package com.bobocode.cs;

import java.io.IOException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

  private static final int SIZE_ARRAY = 20_000_000;


  public static void main(String[] args) throws IOException {
    int[] randomArray;
    System.out.println("Simple Merge Sorting an array of 20_000_000 random integers");
    for (int i = 0; i < 10; i++) {
      randomArray = getRandomArray();
      long l = System.currentTimeMillis();
      MergeSort.mergeSort(randomArray, randomArray.length);
      System.out.println(i + 1 + " - " + (System.currentTimeMillis() - l) + " ms");
    }

    System.out.println();
    System.out.println("==================================================================");
    System.out.println("Concurrent Merge Sorting an array of 20_000_000 random integers");

    for (int i = 0; i < 10; i++) {
      randomArray = getRandomArray();
      long l = System.currentTimeMillis();
      ForkJoinPool.commonPool().invoke(new MergeSortFork(randomArray));
      System.out.println(i + 1 + " - " + (System.currentTimeMillis() - l) + " ms");
    }
  }

  private static int[] getRandomArray() {
    int[] array = new int[SIZE_ARRAY];
    for (int i = 0; i < array.length; i++) {
      array[i] = ThreadLocalRandom.current().nextInt();
    }
    return array;
  }
}
