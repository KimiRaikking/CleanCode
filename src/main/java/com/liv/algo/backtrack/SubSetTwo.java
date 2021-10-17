package com.liv.algo.backtrack;


import java.util.*;

/***
 * 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
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
 */
public class SubSetTwo {

    public List<List<Integer>> subsetsWithDup1(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(0,nums,temp,results,true);
        return results;
    }


    private void dfs(int curIndex, int[] nums, List<Integer> temp, List<List<Integer>> results, boolean preChoose){
        if(curIndex == nums.length){
            results.add(new ArrayList<>(temp));
            return;
        }
        if(!preChoose && nums[curIndex] == nums[curIndex-1] && curIndex>=1){
            dfs(curIndex+1,nums,temp,results,false);
            return;
        }
        temp.add(nums[curIndex]);
        dfs(curIndex+1, nums, temp, results, true);
        temp.remove(temp.size()-1);
        dfs(curIndex+1, nums, temp, results,false);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer, Integer> numsCountMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int cur = nums[i];
            numsCountMap.compute(cur, (k,v)->{
                if(null == v){
                    v = 1;
                }else{
                    v++;
                }
                return v;
            });
        }
        List<int[]> numsCountList = new ArrayList<>();
        numsCountMap.forEach((k,v) ->{
            numsCountList.add(new int[]{k,v});
        });
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backTrack(0,temp,numsCountList,results);
        return results;
    }

    private void backTrack(int curIndex, List<Integer> temp, List<int[]> numsCountList, List<List<Integer>> results){
        if(curIndex == numsCountList.size()){
            // 遍历完，直接add结果
            results.add(new ArrayList<>(temp));
            return;
        }
        int[] numCount = numsCountList.get(curIndex);
        int val = numCount[0];
        int count = numCount[1];
        for(int i=0;i<=count;i++){
            if(i==0){
                List<Integer> newTemp = new ArrayList<>(temp);
                backTrack(curIndex+1, newTemp,numsCountList,results);
            }else{
                temp.add(val);
                List<Integer> newTemp = new ArrayList<>(temp);
                backTrack(curIndex+1, newTemp, numsCountList, results);
            }
        }
    }
}
