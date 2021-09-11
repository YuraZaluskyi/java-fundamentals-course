package com.bobocode.cs;

import com.bobocode.util.ExerciseNotCompletedException;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * {@link ArrayList} is an implementation of {@link List} interface. This resizable data structure
 * based on an array and is simplified version of {@link java.util.ArrayList}.
 */
public class ArrayList<T> implements List<T> {

  private static final int DEFAULT_CAPACITY = 5;
  private int size;
  private Object[] array;

  /**
   * This constructor creates an instance of {@link ArrayList} with a specific capacity of an array
   * inside.
   *
   * @param initCapacity - the initial capacity of the list
   * @throws IllegalArgumentException – if the specified initial capacity is negative or 0.
   */
  public ArrayList(int initCapacity) {
//    throw new ExerciseNotCompletedException(); // todo: implement this method
    if (initCapacity < 0) {
      throw new IllegalArgumentException();
    }
    array = new Object[initCapacity];
  }

  /**
   * This constructor creates an instance of {@link ArrayList} with a default capacity of an array
   * inside. A default size of inner array is 5;
   */
  public ArrayList() {
//    throw new ExerciseNotCompletedException(); // todo: implement this method
    array = new Object[DEFAULT_CAPACITY];
  }

  /**
   * Creates and returns an instance of {@link ArrayList} with provided elements
   *
   * @param elements to add
   * @return new instance
   */
  public static <T> List<T> of(T... elements) {
//    throw new ExerciseNotCompletedException(); // todo: implement this method
    List<T> list = new ArrayList<>();
    Stream.of(elements).forEach(list::add);
    return list;
  }

  /**
   * Adds an element to the array.
   *
   * @param element element to add
   */
  @Override
  public void add(T element) {
//    throw new ExerciseNotCompletedException(); // todo: implement this method
    increaseArrayIfNeeded();
    array[size++] = element;
  }

  private void increaseArrayIfNeeded() {
    int n = array.length;
    if (size == n) {
      Object[] newArray = new Object[n * 2];
      System.arraycopy(array, 0, newArray, 0, n);
      array = newArray;
    }
  }

  /**
   * Adds an element to the specific position in the array where
   *
   * @param index index of position
   * @param element element to add
   */
  @Override
  public void add(int index, T element) {
//    throw new ExerciseNotCompletedException(); // todo: implement this method
//    Objects.checkIndex(index, size);
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    if (index == size) {
      add(element);
    } else {
      increaseArrayIfNeeded();
      System.arraycopy(array, index, array, index + 1, size - index);
      array[index] = element;
      size++;
    }
  }

  /**
   * Retrieves an element by its position index. In case provided index in out of the list bounds it
   * throws {@link IndexOutOfBoundsException}
   *
   * @param index index of element
   * @return en element
   */
  @Override
  public T get(int index) {
//    throw new ExerciseNotCompletedException(); // todo: implement this method
    Objects.checkIndex(index, size);
    return (T) array[index];
  }

  /**
   * Returns the first element of the list. Operation is performed in constant time O(1)
   *
   * @return the first element of the list
   * @throws java.util.NoSuchElementException if list is empty
   */
  @Override
  public T getFirst() {
//    throw new ExerciseNotCompletedException(); // todo: implement this method
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return (T) array[0];
  }

  /**
   * Returns the last element of the list. Operation is performed in constant time O(1)
   *
   * @return the last element of the list
   * @throws java.util.NoSuchElementException if list is empty
   */
  @Override
  public T getLast() {
//    throw new ExerciseNotCompletedException(); // todo: implement this method
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return (T) array[size - 1];
  }

  /**
   * Changes the value of array at specific position. In case provided index in out of the list
   * bounds it throws {@link IndexOutOfBoundsException}
   *
   * @param index position of value
   * @param element a new value
   */
  @Override
  public void set(int index, T element) {
//    throw new ExerciseNotCompletedException(); // todo: implement this method
    Objects.checkIndex(index, size);
    array[index] = element;
  }

  /**
   * Removes an elements by its position index. In case provided index in out of the list bounds it
   * throws {@link IndexOutOfBoundsException}
   *
   * @param index element index
   * @return deleted element
   */
  @Override
  public T remove(int index) {
//    throw new ExerciseNotCompletedException(); // todo: implement this method
    Objects.checkIndex(index, size);
    if (index == size - 1) {
      return removeLastElementByIndex();
    } else {
      T element = (T) array[index];
      System.arraycopy(array, index + 1, array, index, size - index - 1);
      size--;
      return element;
    }
  }

  private T removeLastElementByIndex() {
    T element = (T) array[size - 1];
    array[size - 1] = null;
    size--;
    return element;
  }


  /**
   * Checks for existing of a specific element in the list.
   *
   * @param element is element
   * @return If element exists method returns true, otherwise it returns false
   */
  @Override
  public boolean contains(T element) {
//    throw new ExerciseNotCompletedException(); // todo: implement this method
    for (int i = 0; i < size; i++) {
      if (array[i].equals(element)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Checks if a list is empty
   *
   * @return {@code true} if list is empty, {@code false} otherwise
   */
  @Override
  public boolean isEmpty() {
//    throw new ExerciseNotCompletedException(); // todo: implement this method
    return size == 0;
  }

  /**
   * @return amount of saved elements
   */
  @Override
  public int size() {
//    throw new ExerciseNotCompletedException(); // todo: implement this method
    return size;
  }

  /**
   * Removes all list elements
   */
  @Override
  public void clear() {
//    throw new ExerciseNotCompletedException(); // todo: implement this method
    size = 0;
    array = new Object[DEFAULT_CAPACITY];
  }
}
