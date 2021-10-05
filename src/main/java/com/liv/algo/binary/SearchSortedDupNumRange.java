package com.liv.algo.binary;

public class SearchSortedDupNumRange {

    public int[] searchRange(int[] nums, int target) {
        if(null == nums || nums.length == 0){
            return new int[]{-1,-1};
        }
        int left = searchLeftTaget(nums,target);
        int right = searchRightTaget(nums,target);
        return new int[]{left,right};
    }

    private int searchLeftTaget(int[] nums, int target){
        int len = nums.length;
        int left = 0;
        int right = len-1;
        if(nums[left] == target){
            return left;
        }
        int mid = -1;
        while(left<=right){
            mid = left + (right-left)/2;
            if(nums[mid] == target && nums[mid] > nums[mid-1]){
                return mid;
            }else if(nums[mid] < target){
                left = mid +1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }

    private int searchRightTaget(int[] nums, int target){
        int len = nums.length;
        int left = 0;
        int right = len-1;
        if(nums[right] == target){
            return right;
        }
        int mid = -1;
        while(left<=right){
            mid = left + (right-left)/2;
            if(nums[mid] == target && nums[mid] < nums[mid+1]){
                return mid;
            }else if(nums[mid] <= target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }

    }
