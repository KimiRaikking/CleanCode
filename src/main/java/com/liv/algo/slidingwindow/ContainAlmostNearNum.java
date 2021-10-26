package com.liv.algo.slidingwindow;


import java.util.Arrays;
import java.util.TreeMap;

/***
 * 220. 存在重复元素 III
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 *
 * 如果存在则返回 true，不存在返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [1,0,1,1], k = 1, t = 2
 * 输出：true
 * 示例 3：
 *
 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出：false
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 104
 * 0 <= t <= 231 - 1
 */
public class ContainAlmostNearNum {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k == 0) {
            return t >= 0;
        }
        int len = nums.length;
        int left = 0;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(nums[0], 1);
        for (int right = 1; right < len; right++) {
            treeMap.compute(nums[right-1],(key,v)->{
                if(v == null){
                    v = 1;
                }else{
                    v++;
                }
                return v;
            });
            while ((right - left) > k) {
                treeMap.compute(nums[left], (key, v) -> {
                    if (null != v && v > 1) {
                        v--;
                        return v;
                    } else {
                        return null;
                    }
                });
                left++;
            }
            if (isSatisfied(nums, treeMap, right, t)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSatisfied(int[] nums, TreeMap<Integer, Integer> treeMap, int right, int t) {
        int target = nums[right];
        if(treeMap.isEmpty()){
            return false;
        }
        if (treeMap.containsKey(target) ||
                Math.abs((long) target - (long) treeMap.ceilingKey(target)) <= t ||
                Math.abs((long) target - (long) treeMap.floorKey(target)) <= t) {
            return true;
        }
        return false;
    }

    private boolean isSatisfied(int[] nums, int left, int right, int t) {
        int targetValue = nums[right];
        int[] sortedNums = Arrays.copyOfRange(nums, left, right);
        Arrays.sort(sortedNums);
        if (Math.abs((long) sortedNums[0] - (long) targetValue) <= t ||
                Math.abs((long) sortedNums[sortedNums.length - 1] - (long) targetValue) <= t) {
            return true;
        }
        return false;
    }
}
