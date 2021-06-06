package com.liv.algo.bst;


import java.util.Collections;

/***
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 *  
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 *
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 *
 * 输入: [1,3,2,6,5]
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BackTraverseCheck {

    public boolean verifyPostorder(int[] postorder) {
        return checkPostOrder(postorder, 0, postorder.length - 1);
    }


    private boolean checkPostOrder(int[] postorder, int from, int to) {
        if (from >= to) {
            return true;
        }
        int rootNodeVal = postorder[to];
        int index = from;
        while(postorder[index] < rootNodeVal) index++;
        // check right tree
        int checkRightIndex = index;
        while (postorder[checkRightIndex]> rootNodeVal)checkRightIndex++;
        return checkRightIndex== to && checkPostOrder(postorder, from, index - 1) && checkPostOrder(postorder, index, to - 1);
    }

    public static void main(String[] args) {
        BackTraverseCheck check = new BackTraverseCheck();
        int[] post = {1, 2, 5, 10, 6, 9, 4, 3};
        System.out.println(check.verifyPostorder(post));
    }


}
