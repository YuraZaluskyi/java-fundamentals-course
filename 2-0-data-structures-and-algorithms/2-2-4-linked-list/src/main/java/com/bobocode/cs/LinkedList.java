package com.bobocode.cs;


import com.bobocode.util.ExerciseNotCompletedException;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * {@link LinkedList} is a list implementation that is based on singly linked generic nodes. A node
 * is implemented as inner static class {@link Node<T>}.
 *
 * @param <T> generic type parameter
 */
public class LinkedList<T> implements List<T> {

  Node<T> first;
  Node<T> last;
  int size;

  private static class Node<T> {

    T elem;
    Node<T> next;

    public Node(T elem) {
      this.elem = elem;
    }
  }

  /**
   * This method creates a list of provided elements
   *
   * @param elements elements to add
   * @param <T> generic type
   * @return a new list of elements the were passed as method parameters
   */
  public static <T> LinkedList<T> of(T... elements) {
    throw new ExerciseNotCompletedException(); // todo: implement this method
  }

  /**
   * Adds an element to the end of the list.
   *
   * @param element element to add
   */
  @Override
  public void add(T element) {
//    throw new ExerciseNotCompletedException(); // todo: implement this method
    Node<T> newNode = new Node<>(element);
    if (size == 0) {
      first = newNode;
      last = first;
    } else {
      last.next = newNode;
      last = newNode;
    }
    size++;
  }

  private Node<T> getNodeByIndex(int index) {
    Node<T> current = first;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    return current;
  }

  /**
   * Adds a new element to the specific position in the list. In case provided index in out of the
   * list bounds it throws {@link IndexOutOfBoundsException}
   *
   * @param index an index of new element
   * @param element element to add
   */
  @Override
  public void add(int index, T element) {
//    throw new ExerciseNotCompletedException(); // todo: implement this method
    Objects.checkIndex(index, size);
    Node<T> newNode = new Node<>(element);

    if (size > 0 && index == 0) {
      addToHeadWhenListNotEmpty(element);
    } else if (index == size - 1) {
      addByIndexToTheEndOfList(element);
    } else {
      Node<T> nodeByIndex = getNodeByIndex(index - 1);
      Node<T> node = nodeByIndex.next;
      nodeByIndex.next = newNode;
      newNode.next = node;
    }
    size++;
  }

  private void addToHeadWhenListNotEmpty(T element) {
    Node<T> newNode = new Node<>(element);
    newNode.next = first;
    first = newNode;
  }

  private void addByZeroIndexWhenListIsEmpty(T element) {
    first = new Node<>(element);
    last = first;
  }

  private void addByIndexToTheEndOfList(T element) {
    Node<T> nodeByIndex = getNodeByIndex(size - 2);
    nodeByIndex.next = new Node<>(element);
    nodeByIndex.next.next = last;
  }

  /**
   * Changes the value of an list element at specific position. In case provided index in out of the
   * list bounds it throws {@link IndexOutOfBoundsException}
   *
   * @param index an position of element to change
   * @param element a new element value
   */
  @Override
  public void set(int index, T element) {
//    throw new ExerciseNotCompletedException(); // todo: implement this method
    Objects.checkIndex(index, size);
    if (size == 0) {
      first = new Node<>(element);
      last = first;
      size++;
    } else {
      getNodeByIndex(index).elem = element;
    }
  }

  /**
   * Retrieves an elements by its position index. In case provided index in out of the list bounds
   * it throws {@link IndexOutOfBoundsException}
   *
   * @param index element index
   * @return an element value
   */
  @Override
  public T get(int index) {
//    throw new ExerciseNotCompletedException(); // todo: implement this method
    Objects.checkIndex(index, size);
    if (index == 0) {
      return first.elem;
    }
    if (index == size - 1) {
      return last.elem;
    }
    return getNodeByIndex(index).elem;
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
    if (first == null) {
      throw new NoSuchElementException();
    }
    return first.elem;
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
    if (first == null) {
      throw new NoSuchElementException();
    }
    return last.elem;
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
    if (index == 0) {
      return removeFirst();
    }
    if (index == size - 1) {
      return removeLast();
    }
    Node<T> nodeByIndex = getNodeByIndex(index);
    Node<T> previousNode = getNodeByIndex(index - 1);
    Node<T> nextNode = getNodeByIndex(index + 1);
    previousNode.next = nextNode;
    size--;
    return nodeByIndex.elem;
  }

  private T removeFirst() {
    Node<T> node = first;
    first = first.next;
    size--;
    return node.elem;
  }

  private T removeLast() {
    Node<T> node = last;
    last = getNodeByIndex(size - 2);
    last.next = null;
    size--;
    return node.elem;
  }


  /**
   * Checks if a specific exists in he list
   *
   * @return {@code true} if element exist, {@code false} otherwise
   */
  @Override
  public boolean contains(T element) {
//    throw new ExerciseNotCompletedException(); // todo: implement this method
    if (first == null) {
      return false;
    }
    Node<T> current = first;
    while (current.next != null) {
      if (current.elem.equals(element)) {
        return true;
      }
      current = current.next;
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
    return first == null;
  }

  /**
   * Returns the number of elements in the list
   *
   * @return number of elements
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
    first = null;
    last = null;
  }
}
