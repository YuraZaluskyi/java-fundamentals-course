package com.bobcode.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MergeSortTest {

  private static int[] array = {3, 6, 1, 9, 4, 2, 0};
  private static int[] expectedArray = {0, 1, 2, 3, 4, 6, 9};

  @Test
  void mergeSort() {
    InsertionSort.insertSort(array);
    Assertions.assertArrayEquals(expectedArray, array);
  }
}