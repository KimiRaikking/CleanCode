package com.liv.algo.dp;


import java.lang.management.MonitorInfo;

/***
 * 322. 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 *
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 *
 * 输入：coins = [1], amount = 2
 * 输出：2
 *
 *
 * 提示：
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
public class CoinsChange {

    public int coinChange(int[] coins, int amount) {
        if(null == coins || coins.length==0){
            return -1;
        }
        if(amount<=0){
            return 0;
        }
        int[] dp = new int[amount+1];
        dp[0] = 0;

        for(int i=1;i<=amount;i++){
            dp[i] = -1;
            for(int j=0;j<coins.length;j++){
                int curCoin = coins[j];
                if(i>= curCoin && dp[i-curCoin] != -1){
                    dp[i] = dp[i] == -1? dp[i-curCoin]+1 :Math.min(dp[i], dp[i-curCoin]+1);
                }
            }
        }
        return dp[amount];
    }
}
