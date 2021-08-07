package com.liv.algo.slidingwindow;

public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res=0;
        if(null == nums || nums.length==0){
            return res;
        }
        int left=0;
        int product=1;
        for(int right=0;right<nums.length;right++){
            product = product*nums[right];
            while(product>= k && left<=right){
                product = product/nums[left];
                left++;
            }
            res += right-left+1;
        }
        return res;
    }
}
