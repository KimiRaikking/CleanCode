package com.liv.algo.math;

/***
 * 在组合数学中，如果一个排列中所有元素都不在原先的位置上，那么这个排列就被称为错位排列。
 *
 * 给定一个从 1 到 n 升序排列的数组，你可以计算出总共有多少个不同的错位排列吗？
 *
 * 由于答案可能非常大，你只需要将答案对 109+7 取余输出即可。
 *
 *  
 *
 * 样例 1:
 *
 * 输入: 3
 * 输出: 2
 * 解释: 原始的数组为 [1,2,3]。两个错位排列的数组为 [2,3,1] 和 [3,1,2]。
 *  
 *
 * 注释:
 * n 的范围是 [1, 106]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-derangement-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindDerangement {

    public int findDerangement(int n) {
        if(n<=1){
            return 0;
        }
        if(n==2){
            return 1;
        }
        long[] dp = new long[n+1];
        dp[1] = 0;
        dp[2] = 1;
        long chushu = (long) (Math.pow(10,9)+7);
        for(int i=3;i<=n;i++){
            dp[i] = (i-1)*(dp[i-1]+dp[i-2])%chushu;
        }
        return (int) dp[n];
    }

    public static void main(String[] args) {
        int n = 23;
        FindDerangement findDerangement = new FindDerangement();
        findDerangement.findDerangement(n);
    }
}
