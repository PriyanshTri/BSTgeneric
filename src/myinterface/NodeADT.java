package myinterface;
import implementation.Node;
public interface NodeADT<E extends Comparable<E>> {
    E getData();
    void setData(E data);
    Node<E> getLeft();
    void setLeft(Node<E> node);
    Node<E> getRight();
    void setRight(Node<E> node);
}
