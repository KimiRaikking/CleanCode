package com.liv.algo.dp;


import java.util.*;

/***
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 示例 3：
 *
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * 示例 4：
 *
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * 示例 5：
 *
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 */
public class MaxSlidingWindow {



    public int[] maxSlidingWindow(int[] nums, int k) {
        if(null == nums||nums.length==0 || k<=0){
            return new int[0];
        }
        int numLen = nums.length;
        List<Integer> numsList = new ArrayList<>();
        for(int i=0;i<numLen;i++){
            numsList.add(nums[i]);
        }
        if(k>=numLen){
            return new int[]{Collections.max(numsList)};
        }
        int[][] dp = new int[k+1][numLen];
        for(int i=0;i<numLen;i++){
            dp[1][i] = nums[i];
        }
        for(int i=2;i<=k;i++){
            for(int j=0;j<(numLen-i+1);j++){
                dp[i][j] = Math.max(dp[i-1][j], nums[j+i-1]);
            }
        }
        return Arrays.copyOf(dp[k], numLen-k+1);
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        if(null == nums||nums.length==0 || k<=0){
            return new int[0];
        }
        int numLen = nums.length;
        List<Integer> numsList = new ArrayList<>();
        for(int i=0;i<numLen;i++){
            numsList.add(nums[i]);
        }
        if(k>=numLen){
            return new int[]{Collections.max(numsList)};
        }
        int[] dp = new int[numLen];
        for(int i=0;i<numLen;i++){
            dp[i] = nums[i];
        }
        for(int i=2;i<=k;i++){
            for(int j=0;j<(numLen-i+1);j++){
                dp[j] = Math.max(dp[j], nums[j+i-1]);
            }
        }
        return Arrays.copyOf(dp, numLen-k+1);
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(null == nums||nums.length==0 || k<=0){
            return new int[0];
        }
        int numLen = nums.length;
        List<Integer> numsList = new ArrayList<>();
        for(int i=0;i<numLen;i++){
            numsList.add(nums[i]);
        }
        if(k>=numLen){
            return new int[]{Collections.max(numsList)};
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2) -> {
            return o1[0]!=o2[0]?o2[0]-o1[0]:o2[1]-o1[1];
        });
        int resLen = numLen - k+1;
        int[] res = new int[resLen];
        for(int i=0;i<numLen;i++){
            int curVal = nums[i];
            if(queue.isEmpty()|| queue.size()<k){
                queue.offer(new int[]{curVal, i});
            }else{
                queue.offer(new int[]{curVal, i});
                while(queue.peek()[1]<= (i-k)){
                    queue.poll();
                }
            }
            if(i>=(k-1)){
                res[i-k+1] = queue.peek()[0];
            }
        }
        return res;
    }
}
