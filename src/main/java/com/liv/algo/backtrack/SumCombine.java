package com.liv.algo.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/***
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 注意：解集不能包含重复的组合。
 *
 *
 *
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 * 提示:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
public class SumCombine {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (null == candidates || candidates.length == 0) {
            return results;
        }
        Arrays.sort(candidates);
        List<Integer> curCandidates = new ArrayList<>();
        for (int candidate : candidates) {
            curCandidates.add(candidate);
        }

        List<Integer> nums = new ArrayList<>();
        backTrack(results, curCandidates, nums, target);
        return results;
    }

    private void backTrack(List<List<Integer>> results, List<Integer> curCandidates, List<Integer> nums, int target) {
        // cal current sum
        int sum = nums.stream().mapToInt(x -> x).sum();
        if (sum == target) {
            results.add(nums);
            return;
        }
        if (sum > target) {
            return;
        }
        if (null == curCandidates || curCandidates.size() == 0) {
            return;
        }
        // sum < target
        for (int i = 0; i < curCandidates.size(); i++) {
            if(i>0 && curCandidates.get(i) == curCandidates.get(i-1)){
                continue;
            }
            List<Integer> childCandidates = i==curCandidates.size()-1? new ArrayList<>():new ArrayList<>(curCandidates.subList(i+1,curCandidates.size()));
            Integer num = curCandidates.get(i);
            List<Integer> curNums = new ArrayList<>(nums);
            curNums.add(num);
            backTrack(results, childCandidates, curNums, target);
        }
    }
}
