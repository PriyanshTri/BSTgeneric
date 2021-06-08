package myinterface;

import implementation.Node;

public interface BSTADT<E extends Comparable<E>> {
    void insert(E data);
    void delete(E data);
    boolean search(E data);
    void inOrder(Node<E> node);
    void preOrder(Node<E> node);
    void postOrder(Node<E> node);
    void reverseInOrder(Node<E> node);
    boolean isEmpty();
}
