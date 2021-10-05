package com.liv.algo.doublepoint;

/***
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum1(int[] nums){
        List<List<Integer>> sums = new ArrayList<>();
        if(null == nums || nums.length<3){
            return sums;
        }
        Arrays.sort(nums);
        for(int first=0;first<nums.length;first++){
            if(first>0 && nums[first] == nums[first-1]){
                continue;
            }
            int firstValue = nums[first];
            int third = nums.length-1;
            int targetValue = -firstValue;
            for(int second = first+1;second<nums.length-1;second++){
                if(second > (first+1) &&nums[second] == nums[second-1]){
                    continue;
                }
                if(nums[second]+nums[third] < targetValue){
                    continue;
                }
                while (second<third && (nums[second]+nums[third]) > targetValue){
                    third--;
                }
                if(second == third){
                    break;
                }
                if(nums[second] + nums[third] == targetValue){
                    sums.add(generateNewSumsGroup(nums[first], nums[second], nums[third]));
                    continue;
                }
            }
        }
        return sums;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sums = new ArrayList<>();
        if(null == nums || nums.length<3){
            return sums;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int numValue = nums[i];
            if(numValue>0){
                break;
            }
            if(i>1 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while(left< right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum == 0){
                    sums.add(generateNewSumsGroup(nums[i], nums[left], nums[right]));
                    while(left<right && nums[left] == nums[++left]);
                    while (left<right && nums[right] == nums[--right]);
                }else if(sum > 0){
                    while (left<right && nums[right] == nums[--right]);
                }else{
                    while(left<right && nums[left] == nums[++left]);
                }
            }
        }
        return sums;
    }

    private List<Integer> generateNewSumsGroup(int first, int second, int third){
        List<Integer> numsGroup = new ArrayList<>();
        numsGroup.add(first);
        numsGroup.add(second);
        numsGroup.add(third);
        return numsGroup;
    }


}
