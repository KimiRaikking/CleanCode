package com.liv.data;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/***
 * 645. 错误的集合
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 *
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 *
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 * 示例 2：
 *
 * 输入：nums = [1,1]
 * 输出：[1,2]
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 104
 * 1 <= nums[i] <= 104
 */
public class FindErrorNums {

    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        Set<Integer> numSet = new HashSet<>();
        int[] missedNums = new int[nums.length];
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(!numSet.add(nums[i])){
                res[0] = nums[i];
            }
            missedNums[nums[i]-1] = 1;
        }
        for(int i=0;i<missedNums.length;i++){
            if(missedNums[i] == 0){
                res[1] = i+1;
            }
        }
        return res;
    }
}
