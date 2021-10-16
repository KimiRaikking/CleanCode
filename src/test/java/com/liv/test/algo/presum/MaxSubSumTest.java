package com.liv.test.algo.presum;

import com.liv.algo.presum.MaxSubSum;
import org.junit.Assert;
import org.junit.Test;

public class MaxSubSumTest {


    private static final MaxSubSum maxSubSum = new MaxSubSum();

    @Test
    public void test(){
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int max = maxSubSum.maxSubArray(nums);
        Assert.assertEquals(max, 6);
    }
}
