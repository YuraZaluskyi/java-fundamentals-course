package com.bobocode.cs;

import com.bobocode.util.ExerciseNotCompletedException;

/**
 * {@link LinkedQueue} implements FIFO {@link Queue}, using singly linked nodes. Nodes are stores in
 * instances of nested class Node. In order to perform operations {@link LinkedQueue#add(Object)}
 * and {@link LinkedQueue#poll()} in a constant time, it keeps to references to the head and tail of
 * the queue.
 *
 * @param <T> a generic parameter
 */
public class LinkedQueue<T> implements Queue<T> {

  Node<T> head;
  Node<T> tail;
  int size;

  private static class Node<T> {

    T elem;
    Node<T> next;

    public Node(T elem) {
      this.elem = elem;
    }
  }

  /**
   * Adds an element to the end of the queue.
   *
   * @param element the element to add
   */
  public void add(T element) {
//    throw new ExerciseNotCompletedException(); // todo: implement this method
    if (size == 0) {
      head = new Node<>(element);
      tail = head;
    } else {
      Node<T> node = tail;
      tail.next = new Node<>(element);
      tail = node.next;
    }
    size++;
  }

  /**
   * Retrieves and removes queue head.
   *
   * @return an element that was retrieved from the head or null if queue is empty
   */
  public T poll() {
//    throw new ExerciseNotCompletedException(); // todo: implement this method
    if (size == 0) {
      return null;
    }
    Node<T> node = head;
    head = head.next;
    size--;
    return node.elem;
  }

  /**
   * Returns a size of the queue.
   *
   * @return an integer value that is a size of queue
   */
  public int size() {
//    throw new ExerciseNotCompletedException(); // todo: implement this method
    return size;
  }

  /**
   * Checks if the queue is empty.
   *
   * @return {@code true} if the queue is empty, returns {@code false} if it's not
   */
  public boolean isEmpty() {
//    throw new ExerciseNotCompletedException(); // todo: implement this method
    return size == 0;
  }
}
