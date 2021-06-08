package implementation;

import myinterface.BSTADT;

@SuppressWarnings("ConstantConditions")
public class MyBST<E extends Comparable<E>> implements BSTADT<E> {
    private Node<E> root;

    public Node<E> getRoot() {
        return root;
    }


    @Override
    public void insert(E data) {
        Node<E> node = new Node<>(data);
        if (isEmpty()) {
            root = node;
        } else {
            Node<E> temp = root;
            Node<E> parent = null;
            while (temp != null) {
                parent = temp;
                if (data.compareTo(temp.getData()) < 0) {
                    temp = temp.getLeft();
                } else {
                    temp = temp.getRight();
                }
            }
            //noinspection ConstantConditions
            if (data.compareTo(parent.getData()) < 0) {
                parent.setLeft(node);
            } else {
                parent.setRight(node);
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void delete(E data) {
        Node<E> temp = root;
        Node<E> parent = null;
        while (temp != null) {
            parent = temp;
            if (data.compareTo(temp.getData()) == 0) {
                break;
            } else {
                if (data.compareTo(temp.getData()) < 0) {
                    temp = temp.getLeft();
                } else {
                    temp = temp.getRight();
                }
            }
        }
        if (temp != null) {
            //case1 - if deleting node is leaf node
            if (isLeaf(temp)) {
                //root condition
                //noinspection ConstantConditions
                if (parent == null) {
                    temp = null;
                } else {
                    if (data.compareTo(parent.getData()) < 0) {
                        parent.setLeft(null);
                    } else {
                        parent.setRight(null);
                    }
                }

            }
            //case 2
            //it has 2 parts
            //part 1: has left child only
            else if (hasLeftChild(temp)) {
                //root condition
                //noinspection ConstantConditions
                if (parent == null) {
                    root = temp.getLeft();
                } else {
                    if (data.compareTo(parent.getData()) < 0) {
                        parent.setLeft(temp.getLeft());
                    } else {
                        parent.setRight(temp.getLeft());
                    }

                }

            }
            //part 2: has right child only
            else if (hasRightChild(temp)) {
                //root condition
                //noinspection ConstantConditions
                if (parent == null) {
                    root = temp.getRight();
                } else {
                    if (data.compareTo(parent.getData()) < 0) {
                        parent.setLeft(temp.getRight());
                    } else {
                        parent.setRight(temp.getRight());
                    }
                }
            } else {
                Node<E> successor = getSuccessor(temp);
                delete(successor.getData());
                successor.setLeft(temp.getLeft());
                successor.setRight(temp.getRight());
                //root condition
                //noinspection ConstantConditions
                if (parent == null) {
                    root = successor;
                } else {
                    if (data.compareTo(parent.getData()) < 0) {
                        parent.setLeft(successor);
                    } else {
                        parent.setRight(successor);
                    }
                }
            }
            System.out.println(data + " deleted!");
        } else {
            System.out.println("element not found!");
        }

    }

    @Override
    public boolean search(E data) {
        boolean response = false;
        if (!isEmpty()) {
            Node<E> temp = root;
            while (temp != null) {
                if (data.compareTo(temp.getData()) == 0) {
                    response = true;
                    break;
                } else {
                    if (data.compareTo(temp.getData()) < 0) {
                        temp = temp.getLeft();
                    } else {
                        temp = temp.getRight();
                    }
                }
            }
        }
        return response;
    }

    @Override
    public void inOrder(Node<E> node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getData() + ", ");
            inOrder(node.getRight());
        }
    }

    @Override
    public void preOrder(Node<E> node) {
        if (node != null) {
            System.out.print(node.getData() + ", ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    @Override
    public void postOrder(Node<E> node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getData() + ", ");
        }
    }

    @Override
    public void reverseInOrder(Node<E> node) {
        if (node != null) {
            reverseInOrder(node.getRight());
            System.out.print(node.getData() + ", ");
            reverseInOrder(node.getLeft());
        }
    }

    private boolean isLeaf(Node<E> node) {
        return node.getRight() == null && node.getLeft() == null;
    }

    private boolean hasLeftChild(Node<E> node) {
        return node.getLeft() != null && node.getRight() == null;
    }

    private boolean hasRightChild(Node<E> node) {
        return node.getRight() != null && node.getLeft() == null;
    }

    private Node<E> getSuccessor(Node<E> node) {
        Node<E> temp = node.getRight();
        while (temp.getLeft() != null) {
            temp = temp.getLeft();
        }
        return temp;
    }
}
