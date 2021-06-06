package com.liv.algo.dp;

import com.liv.algo.bst.FindKthLargeNode;

/***
 * 小扣有一个根结点为 root 的二叉树模型，初始所有结点均为白色，可以用蓝色染料给模型结点染色，模型的每个结点有一个 val 价值。小扣出于美观考虑，希望最后二叉树上每个蓝色相连部分的结点个数不能超过 k 个，求所有染成蓝色的结点价值总和最大是多少？
 *
 * 示例 1：
 *
 * 输入：root = [5,2,3,4], k = 2
 *
 * 输出：12
 *
 * 解释：结点 5、3、4 染成蓝色，获得最大的价值 5+3+4=12
 *
 *
 * 示例 2：
 *
 * 输入：root = [4,1,3,9,null,null,2], k = 2
 *
 * 输出：16
 *
 * 解释：结点 4、3、9 染成蓝色，获得最大的价值 4+3+9=16
 *
 *
 * 提示：
 *
 * 1 <= k <= 10
 * 1 <= val <= 10000
 * 1 <= 结点数量 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-ran-se-UGC
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * LCP 34
 */
public class ColoredBinaryTree {

    public int maxValue(TreeNode root, int k) {
        int maxValue = Integer.MIN_VALUE;
        int[] dp = dynamicColorTree(root, k);
        for(int i=0;i<=k;i++){
            maxValue = Math.max(maxValue, dp[i]);
        }
        return maxValue;
    }

    private int[] dynamicColorTree(TreeNode root, int k){
        int[] dp = new int[k+1];
        if(null == root){
            return dp;
        }
        int[] leftTree = dynamicColorTree(root.left, k);
        int[] rightTree = dynamicColorTree(root.right, k);

        // 若root节点不染色
        int maxLeftColoredTreeValue = Integer.MIN_VALUE;
        int maxRightColoredTreeValue = Integer.MIN_VALUE;
        for(int i=0;i<k+1;i++){
            maxLeftColoredTreeValue = Math.max(maxLeftColoredTreeValue, leftTree[i]);
            maxRightColoredTreeValue = Math.max(maxRightColoredTreeValue, rightTree[i]);
        }
        dp[0] = maxLeftColoredTreeValue + maxRightColoredTreeValue;

        // root节点染色
        for(int i=1;i<=k;i++){
            for(int j=0;j<i;j++){
                dp[i] = Math.max(dp[i], leftTree[j] + rightTree[i-j-1]+ root.val);
            }
        }
        return dp;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
