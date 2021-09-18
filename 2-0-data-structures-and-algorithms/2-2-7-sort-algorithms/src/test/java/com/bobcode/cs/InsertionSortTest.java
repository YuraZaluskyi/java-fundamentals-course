package com.bobcode.cs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InsertionSortTest {
  private static int[] array = {3, 6, 1, 9, 4, 2, 0};
  private static int[] expectedArray = {0, 1, 2, 3, 4, 6, 9};

  @Test
  void insertSort() {
    InsertionSort.insertSort(array);
    Assertions.assertArrayEquals(expectedArray,array);
  }
}