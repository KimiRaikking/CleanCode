package com.liv.algo.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> remains = new ArrayList<>();
        for(int num:nums){
            remains.add(num);
        }
        List<Integer> cur = new ArrayList<>();
        dfs(result,remains,cur);
        return result;

    }

    private void dfs(List<List<Integer>> result,List<Integer> remains, List<Integer> cur){
        if(remains.size()==0){
            result.add(cur);
            return;
        }
        for(int i=0;i<remains.size();i++){
            int num = remains.get(i);
            List<Integer> nextCur = new ArrayList<>(cur);
            nextCur.add(num);
            List<Integer> nextRemains = new ArrayList<>(remains);
            nextRemains.remove(i);
            dfs(result,nextRemains,nextCur);
        }
    }
}
