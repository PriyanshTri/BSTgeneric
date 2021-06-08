package main;

import implementation.MyBST;

import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        MyBST<Integer> bst=new MyBST<>();
        System.out.println(bst.isEmpty());
        bst.insert(10);
        bst.insert(20);
        bst.insert(1);
        bst.insert(30);
        bst.insert(240);
        bst.insert(4);
        bst.insert(223);
        bst.insert(13);
        bst.insert(5);
        bst.insert(87);
        bst.insert(78);
        System.out.println(bst.search(10));
        System.out.println(bst.search(2222));
        bst.inOrder(bst.getRoot());
        System.out.println();
        bst.preOrder(bst.getRoot());
        System.out.println();
        bst.postOrder(bst.getRoot());
        System.out.println();
        bst.reverseInOrder(bst.getRoot());
        System.out.println();
        System.out.println(bst.isEmpty());
//        bst.delete(10);
        bst.inOrder(bst.getRoot());
    }
}
