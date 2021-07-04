package com.liv.algo.binary;

public class SplitNumsMinSumMaxSearch {

    public int splitArray(int[] nums, int m){
        //计算left right边界值
        int sum=0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }
        int left = max;
        int right = sum;
        while (left< right){
            int mid = (left+right)/2;
            int splits = splits(nums,mid);
            if(splits> m){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    private int splits(int[] nums, int maxValue){
        int cnt =0;
        int curSum = 0;
        for(int i=0;i<nums.length;i++){
            if((curSum+ nums[i]) > maxValue)
            {
                cnt++;
                curSum = nums[i];
            } else{
                curSum += nums[i];
            }
        }
        cnt++;
        return cnt;
    }
}
