package com.bobcode.cs;

public class InsertionSort {

  public static void insertSort(int[] array) {
    int n = array.length;
    for (int i = 1; i < n; i++) {
      int j = i - 1;
      int current = array[i];
      while (j >= 0 && current < array[j]) {
        array[j + 1] = array[j];
        j--;
      }
      array[j + 1] = current;
    }
  }
}
