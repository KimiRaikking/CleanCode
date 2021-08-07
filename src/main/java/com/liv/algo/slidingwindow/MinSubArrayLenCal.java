package com.liv.algo.slidingwindow;

public class MinSubArrayLenCal {

    public int minSubArrayLen(int target, int[] nums) {
        int res=0;
        if(null == nums || nums.length==0){
            return res;
        }
        int left=0;
        int right=0;
        int sum=0;
        for(;right<nums.length;right++){
            sum += nums[right];
            while(sum>=target && left<=right){
                res = res==0?(right-left+1): Math.min(res, (right-left+1));
                sum -= nums[left];
                left++;
            }
        }
        return res;
    }
}
