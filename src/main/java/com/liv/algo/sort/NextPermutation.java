package com.liv.algo.sort;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if(null == nums || nums.length<=1){
            return;
        }
        int length = nums.length;
        int replaceIndex = -1;
        int targetIndex = -1;
        boolean isSmallerThanLastNum = false;
        for(int i=length-2;i>=0;i--){
            int curNum = nums[i];
            int closeBiggerNum = Integer.MAX_VALUE;
            for(int j=i+1;j<length;j++){
                int num = nums[j];
                if(num> curNum && num < closeBiggerNum){
                    closeBiggerNum = num;
                    isSmallerThanLastNum = true;
                    replaceIndex = i;
                    targetIndex = j;
                }
            }
            if(isSmallerThanLastNum){
                break;
            }
        }
        if(!isSmallerThanLastNum){
            Arrays.sort(nums);
        }else{
            int temp = nums[targetIndex];
            nums[targetIndex] = nums[replaceIndex];
            nums[replaceIndex] = temp;
            Arrays.sort(nums,replaceIndex+1,length);
        }

    }
}
