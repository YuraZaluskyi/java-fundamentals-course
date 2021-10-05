package com.bobocode.cs;

import java.util.Arrays;

public class MergeSort {

  private static int[] array = {3, 6, 1, 9, 4, 2, 0};

  public static void main(String[] args) {
    System.out.println(Arrays.toString(array));
    mergeSort(array, array.length);
    System.out.println(Arrays.toString(array));
  }

  public static void mergeSort(int[] array, int n) {
    if (n < 2) {
      return;
    }
    int mid = n / 2;
    int[] l = new int[mid];
    int[] r = new int[n - mid];
    for (int i = 0; i < mid; i++) {
      l[i] = array[i];
    }
    for (int i = mid; i < n; i++) {
      r[i - mid] = array[i];
    }
    mergeSort(l, mid);
    mergeSort(r, n - mid);

    merge(array, l, r, mid, n - mid);
  }

  private static void merge(int[] a, int[] l, int[] r, int left, int right) {
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < left && j < right) {
      if (l[i] <= r[j]) {
        a[k++] = l[i++];
      } else {
        a[k++] = r[j++];
      }
    }
    while (i < left) {
      a[k++] = l[i++];
    }
    while (j < right) {
      a[k++] = r[j++];
    }
  }
}