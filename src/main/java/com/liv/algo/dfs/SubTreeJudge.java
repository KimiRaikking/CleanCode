package com.liv.algo.dfs;

/***
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 *
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,4,5,1,2], subRoot = [4,1,2]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 * 输出：false
 *  
 *
 * 提示：
 *
 * root 树上的节点数量范围是 [1, 2000]
 * subRoot 树上的节点数量范围是 [1, 1000]
 * -104 <= root.val <= 104
 * -104 <= subRoot.val <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubTreeJudge {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return isSubTreeNode(root, subRoot);
    }

    private boolean isSubTreeNode(TreeNode root, TreeNode subRoot) {
        if (null == root) {
            return null == subRoot;
        }
        TreeNode cur = root;
        if (isSameTree(cur, subRoot)) {
            return true;
        }
        if (isSubTreeNode(cur.left, subRoot)) {
            return true;
        }
        if (isSubTreeNode(cur.right, subRoot)) {
            return true;
        }
        return false;
    }

    private boolean isSameTree(TreeNode oriTree, TreeNode targetTree) {
        if (oriTree == null) {
            return null == targetTree;
        }
        if (targetTree == null) {
            return false;
        }
        if (oriTree.val != targetTree.val) {
            return false;
        }
        return isSameTree(oriTree.left, targetTree.left) && isSameTree(oriTree.right, targetTree.right);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
