package com.liv.algo.backtrack;

import java.util.ArrayList;
import java.util.List;

/***
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 */
public class SubSetOne {

    public List<List<Integer>> subsets1(int[] nums){
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backTrack(0, nums, temp,results);
        return results;

    }

    private void backTrack(int curIndex, int[] nums, List<Integer> temp, List<List<Integer>> results){
        if(curIndex == nums.length){
            results.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[curIndex]);
        backTrack(curIndex+1, nums, temp, results);
        temp.remove(temp.size()-1);
        backTrack(curIndex+1, nums, temp, results);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(null == nums|| nums.length==0){
            results.add(new ArrayList<>());
            return results;
        }
        int len = nums.length;
        results.add(new ArrayList<>());
        for(int i=0;i<len;i++){
            int curVal = nums[i];
            dp(curVal, results);
        }
        return results;
    }

    private void dp(int val, List<List<Integer>> results){
        List<List<Integer>> curRes = new ArrayList<>();
        for(int i=0;i<results.size();i++){
            List<Integer> newSubSets = new ArrayList<>();
            newSubSets.addAll(results.get(i));
            newSubSets.add(val);
            curRes.add(newSubSets);
        }
        results.addAll(curRes);
    }
}
