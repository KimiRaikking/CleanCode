package com.liv.test.algo.binary;

import com.liv.algo.binary.FindMinValueOfRotateNums;
import org.junit.Assert;
import org.junit.Test;

public class FindMinValueOfRotateNumsTest {

    @Test
    public void testFindMinValue(){
        int[] nums = new int[]{3,1,2};
        FindMinValueOfRotateNums findMinValueOfRotateNums = new FindMinValueOfRotateNums();
        Assert.assertEquals(1, findMinValueOfRotateNums.findMin(nums));
    }
}
