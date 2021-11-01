package com.liv.algo.dfs;


import java.util.TreeSet;

/***
 * 298. 二叉树最长连续序列
 * 给你一棵指定的二叉树的根节点 root ，请你计算其中 最长连续序列路径 的长度。
 *
 * 最长连续序列路径 是依次递增 1 的路径。该路径，可以是从某个初始节点到树中任意节点，通过「父 - 子」关系连接而产生的任意路径。且必须从父节点到子节点，反过来是不可以的。
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,3,2,4,null,null,null,5]
 * 输出：3
 * 解释：当中，最长连续序列是 3-4-5 ，所以返回结果为 3 。
 * 示例 2：
 *
 *
 * 输入：root = [2,null,3,2,null,1]
 * 输出：2
 * 解释：当中，最长连续序列是 2-3 。注意，不是 3-2-1，所以返回 2 。
 *
 *
 * 提示：
 *
 * 树中节点的数目在范围 [1, 3 * 104] 内
 * -3 * 104 <= Node.val <= 3 * 104
 */
public class LongestConsecutive {

    public int longestConsecutive(TreeNode root) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        dfs(root, treeSet);
        return treeSet.last();

    }

    private int dfs(TreeNode node, TreeSet<Integer> treeSet) {
        int val = node.val;
        int value = 1;
        if (null != node.left) {
            int leftValue = dfs(node.left, treeSet);
            if (val == node.left.val - 1) {
                value = Math.max(value, leftValue + 1);
            }
        }
        if (null != node.right) {
            int rightValue = dfs(node.right, treeSet);
            if (val == node.right.val - 1) {
                value = Math.max(value, rightValue + 1);
            }
        }
        treeSet.add(value);
        return value;
    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
