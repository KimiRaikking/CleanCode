package com.liv.algo.binary;

public class FindPeakValue {

    public int findPeakElement(int[] nums) {
        if(null == nums || nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return 0;
        }
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            long midValue = nums[mid];
            long midLeftValue = mid>=1?nums[mid-1]: Long.MIN_VALUE;
            long midRightValue = mid<=(right-1)?nums[mid+1]:Long.MIN_VALUE;
            if(midValue> midLeftValue && midValue > midRightValue){
                return mid;
            }else if(midValue <= midLeftValue){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
}
