package com.liv.algo.bst;

public class BstToDoubleList {

    private Node prev;

    private Node head;

    public Node treeToDoublyList(Node root) {
        if(null == root)return root;
        midTraverse(root);
        head.left = prev;
        prev.right = head;
        return head;

    }

    private void midTraverse( Node root){
        if(null == root){
            return;
        }
        midTraverse(root.left);
        if(null != prev){
            prev.right = root;
        }else{
            head = root;
        }
        root.left  = prev;
        prev = root;
        midTraverse(root.right);
    }
}
