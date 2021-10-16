package com.liv.test.algo.stack;

import com.liv.algo.stack.LargestIncreSubArray;
import org.junit.Assert;
import org.junit.Test;

public class LargestIncreSubArrayTest {

    private static final LargestIncreSubArray largestIncreSubArray = new LargestIncreSubArray();

    @Test
    public void test(){
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        Assert.assertEquals(4, largestIncreSubArray.lengthOfLIS(nums));
    }
}
