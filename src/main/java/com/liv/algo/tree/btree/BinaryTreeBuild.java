package com.liv.algo.tree.btree;

import java.util.ArrayList;
import java.util.List;

/***
 * 105. 从前序与中序遍历序列构造二叉树
 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 *
 *
 *
 * 示例 1:
 *
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * 示例 2:
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 *
 * 提示:
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均无重复元素
 * inorder 均出现在 preorder
 * preorder 保证为二叉树的前序遍历序列
 * inorder 保证为二叉树的中序遍历序列
 */
public class BinaryTreeBuild {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (null == preorder || preorder.length == 0) {
            return null;
        }
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        for (int i = 0; i < preorder.length; i++) {
            preOrder.add(preorder[i]);
            inOrder.add(inorder[i]);
        }
        TreeNode root = new TreeNode();
        buildCurNode(root, preOrder, inOrder);
        return root;
    }

    private void buildCurNode(TreeNode node, List<Integer> preorder, List<Integer> inorder) {
        if (null == preorder || preorder.size() == 0) {
            return;
        }
        int val = preorder.get(0);
        node.val = val;

        int inOrderIndex = inorder.indexOf(val);
        if (inOrderIndex > 0) {
            // build left child tree
            List<Integer> leftPreorder = preorder.subList(1, inOrderIndex + 1);
            List<Integer> leftInorder = inorder.subList(0, inOrderIndex);
            TreeNode leftChild = new TreeNode();
            node.left = leftChild;
            buildCurNode(leftChild, leftPreorder, leftInorder);
        }
        if ((inOrderIndex + 1) < inorder.size()) {
            // build right tree
            List<Integer> rightPreOrder = preorder.subList(inOrderIndex + 1, preorder.size());
            List<Integer> rightInOrder = inorder.subList(inOrderIndex + 1, inorder.size());
            TreeNode rightChild = new TreeNode();
            node.right = rightChild;
            buildCurNode(rightChild, rightPreOrder, rightInOrder);
        }
    }

    public static class TreeNode {
        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        TreeNode(int x) {
            val = x;
        }
    }
}
