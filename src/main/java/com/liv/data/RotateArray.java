package com.liv.data;


/***
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 *  
 *
 * 进阶：
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int next = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                int ori = nums[j];
                nums[j] = next;
                next = ori;
            }
        }
    }

    public void rotate1(int[] nums, int k) {
        int len = nums.length;
        k = k%len;
        int count=0;
        for (int j = 0; j < k; j++) {
            if(count>=len){
                break;
            }
            int index = j;
            int next = nums[len - k + j];
            while (index != len - k + j) {
                int ori = nums[index];
                nums[index] = next;
                next = ori;
                index = (index + k) % len;
                count++;
            }
            nums[index] = next;
            count++;
        }
    }

    public void rotate2(int[] nums, int k){
        int len = nums.length;
        k = k%len;
        reverse(nums, 0, len-1);
        reverse(nums,0, k-1);
        reverse(nums,k,len-1);
    }

    private void reverse(int[] nums, int start, int end){
        while(start<end){
            int tmp = nums[end];
            nums[end] = nums[start];
            nums[start] = tmp;
            start++;
            end--;
        }
    }
}
