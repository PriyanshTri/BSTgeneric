package implementation;

import myinterface.NodeADT;

public class Node <E extends Comparable<E>>  implements NodeADT<E>  {
    E data;
    Node<E> left;
    Node<E> right;

    public Node(E data) {
        this.data = data;
    }

    @Override
    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    @Override
    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    @Override
    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }
}
