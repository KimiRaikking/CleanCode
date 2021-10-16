package com.liv.algo.presum;

import java.util.Arrays;

/***
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 *
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 *
 * 输入：nums = [-100000]
 * 输出：-100000
 */
public class MaxSubSum {

    public int maxSubArray(int[] nums) {
        if(null == nums|| nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int[] preSum = new int[nums.length];
        int preSumTmp = 0;
        for(int i=0;i<nums.length;i++){
            preSumTmp += nums[i];
            preSum[i] = preSumTmp;
        }
        int curMin = preSum[0];
        int max = preSum[0];
        for(int i=1;i<preSum.length-1;i++){
            int preVal = preSum[i];
            max = Math.max(max, curMin<0?preVal-curMin:preVal);
            curMin = Math.min(curMin, preVal);
        }
        return max;
    }
}
