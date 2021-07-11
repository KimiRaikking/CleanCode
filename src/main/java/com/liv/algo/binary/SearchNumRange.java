package com.liv.algo.binary;


/***
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchNumRange {

    public int[] searchRange(int[] nums, int target) {

        int leftRange = -1;
        int rightRange = -1;
        if (null == nums || nums.length == 0) {
            return new int[]{leftRange, rightRange};
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                break;
            } else {
                right = mid - 1;
            }
        }
        if (nums[mid] != target) {
            return new int[]{leftRange, rightRange};
        }
        for (int i = left; i <= mid; i++) {
            if (nums[i] == target) {
                leftRange = i;
                break;
            }
        }
        for (int j = right; j >= mid; j--) {
            if (nums[j] == target) {
                rightRange = j;
                break;
            }
        }
        return new int[]{leftRange, rightRange};
    }
}
