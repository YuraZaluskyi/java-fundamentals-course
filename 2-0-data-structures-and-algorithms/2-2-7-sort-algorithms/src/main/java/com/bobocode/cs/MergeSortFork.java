package com.bobocode.cs;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class MergeSortFork extends RecursiveAction {

  private int[] array;
  private int n;

  public MergeSortFork(int[] array) {
    this.array = array;
    this.n = array.length;
  }


  @Override
  protected void compute() {
    if (array.length == 1){
      return;
    }
    int[] left = Arrays.copyOfRange(array, 0, n / 2);
    int[] right = Arrays.copyOfRange(array, n / 2, n);
    MergeSortFork leftSort = new MergeSortFork(left);
    MergeSortFork rightSort = new MergeSortFork(right);
    leftSort.fork();
    rightSort.compute();
    leftSort.join();
    merge(array, left, right);

  }

  private void merge(int[] array, int[] left, int[] right) {
    int i = 0;
    int j = 0;
    while (i < left.length && j < right.length) {
      if (left[i] < right[j]) {
        array[i + j] = left[i++];
      } else {
        array[i + j] = right[j++];
      }
    }
    System.arraycopy(left, i, array, i + j, left.length - i);
    System.arraycopy(right, j, array, i + j, right.length - j);
  }

  public static void main(String[] args) {
    int[] arr = {3,5,2,6,2,4,56,26,86,22};
    System.out.println(Arrays.toString(arr));
    ForkJoinPool.commonPool().invoke(new MergeSortFork(arr));
    System.out.println(Arrays.toString(arr));
  }
}