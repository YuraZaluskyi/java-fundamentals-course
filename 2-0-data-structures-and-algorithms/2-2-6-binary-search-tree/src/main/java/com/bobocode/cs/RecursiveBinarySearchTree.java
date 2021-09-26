package com.bobocode.cs;

import com.bobocode.util.ExerciseNotCompletedException;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class RecursiveBinarySearchTree<T extends Comparable<T>> implements BinarySearchTree<T> {

  Node<T> root;
  int size;

  private static class Node<T> {

    T element;
    Node<T> left;
    Node<T> right;

    public Node(T element) {
      this.element = element;
    }
  }

  public static <T extends Comparable<T>> RecursiveBinarySearchTree<T> of(T... elements) {
//    throw new ExerciseNotCompletedException();
    RecursiveBinarySearchTree<T> binarySearchTree = new RecursiveBinarySearchTree<>();
    Stream.of(elements).forEach(i -> binarySearchTree.insert(i));
    return binarySearchTree;
  }

  @Override
  public boolean insert(T element) {
//    throw new ExerciseNotCompletedException();
    if (root == null) {
      root = new Node<>(element);
      size++;
      return true;
    }
    return insertElement(root, element);
  }

  private boolean insertElement(Node<T> current, T element) {
    if (element.compareTo(current.element) < 0) {
      return insertLeft(current, element);
    } else if (element.compareTo(current.element) > 0) {
      return insertRight(current, element);
    } else {
      return false;
    }
  }

  private boolean insertLeft(Node<T> current, T element) {
    if (current.left == null) {
      current.left = new Node<>(element);
      size++;
      return true;
    } else {
      return insertElement(current.left, element);
    }
  }

  private boolean insertRight(Node<T> current, T element) {
    if (current.right == null) {
      current.right = new Node<>(element);
      size++;
      return true;
    } else {
      return insertElement(current.right, element);
    }
  }

  @Override
  public boolean contains(T element) {
//    throw new ExerciseNotCompletedException();
    Objects.requireNonNull(element);
    return contains(root, element);
  }

  private boolean contains(Node<T> current, T element) {
    if (current == null) {
      return false;
    } else if (element.compareTo(current.element) < 0) {
      return contains(current.left, element);
    } else if (element.compareTo(current.element) > 0) {
      return contains(current.right, element);
    } else {
      return true;
    }
  }

  @Override
  public int size() {
//    throw new ExerciseNotCompletedException();
    return size;
  }

  @Override
  public int depth() {
//    throw new ExerciseNotCompletedException();
    if (root == null) {
      return 0;
    }
    return depth(root) - 1;
  }

  private int depth(Node<T> current) {
    if (current == null) {
      return 0;
    } else {
      return 1 + Math.max(depth(current.left), depth(current.right));
    }
  }

  @Override
  public void inOrderTraversal(Consumer<T> consumer) {
//    throw new ExerciseNotCompletedException();
    inOrderTraversal(root, consumer);
  }

  private void inOrderTraversal(Node<T> current, Consumer<T> consumer) {
    if (current != null) {
      inOrderTraversal(current.left, consumer);
      consumer.accept(current.element);
      inOrderTraversal(current.right, consumer);
    }
  }
}
