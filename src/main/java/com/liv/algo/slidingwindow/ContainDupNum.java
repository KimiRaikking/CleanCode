package com.liv.algo.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/***
 * 219. 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */
public class ContainDupNum {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        for(int right=1;right<len;right++){
            while ((right-left)>k)left++;
            if(isSatisfied(nums,left,right)){
                return true;
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Map<Integer,Integer> numIndexMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(numIndexMap.containsKey(nums[i])){
                int oriIndex = numIndexMap.get(nums[i]);
                if(Math.abs(oriIndex-i)<=k){
                    return true;
                }

            }
            numIndexMap.put(nums[i],i);
        }
        return false;
    }



    private boolean isSatisfied(int[] nums, int left, int right){
        int targetValue = nums[right];
        for(int i=left;i<right;i++){
            if(nums[i] == targetValue){
                return true;
            }
        }
        return false;

    }
}
