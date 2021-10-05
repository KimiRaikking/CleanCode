package com.liv.test.algo.binary;

import com.liv.algo.binary.FindPeakValue;
import org.junit.Assert;
import org.junit.Test;

public class FindPeakValueTest {

    @Test
    public void test(){
        int[] nums = new int[]{1,2};
        FindPeakValue findPeakValue = new FindPeakValue();
        Assert.assertEquals(1, findPeakValue.findPeakElement(nums));
    }

    @Test
    public void test1(){
        int[] nums = new int[]{-2147483648,-2147483647};
        FindPeakValue findPeakValue = new FindPeakValue();
        Assert.assertEquals(1, findPeakValue.findPeakElement(nums));
    }
}
