package com.liv.algo.dp;


import java.util.Arrays;

/***
 * 给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
 *
 * 设计一个算法使得这 m 个子数组各自和的最大值最小。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [7,2,5,10,8], m = 2
 * 输出：18
 * 解释：
 * 一共有四种方法将 nums 分割为 2 个子数组。 其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4,5], m = 2
 * 输出：9
 * 示例 3：
 *
 * 输入：nums = [1,4,4], m = 3
 * 输出：4
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 106
 * 1 <= m <= min(50, nums.length)
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-largest-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SplitNumsMinSumMax {

    public int splitArray(int[] nums, int m) {
        // 计算前缀和
        int[] presums = presum(nums);
        //初始化dp
        int[][] dp = new int[nums.length+1][m+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        // dp 初始状态
        for(int i=0;i< nums.length;i++){
            dp[i][1] = presums[i];
        }

        // dp
        for(int i=1;i< nums.length;i++){
            for(int j=2;j<=m;j++){
                for(int k=0;k<i;k++){
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-k-1][j-1], (presums[i]-presums[i-k-1])));
                }
            }
        }
        return dp[nums.length-1][m];

    }

    private int[] presum(int[] nums){
        int[] presum = new int[nums.length];
        for(int i=0;i< nums.length;i++){
            if(i==0){
                presum[i] = nums[i];
            }else{
                presum[i] = presum[i-1]+ nums[i];
            }
        }
        return presum;
    }

    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int m = 2;
        SplitNumsMinSumMax splitNumsMinSumMax = new SplitNumsMinSumMax();
        splitNumsMinSumMax.splitArray(nums, m);
    }
}
