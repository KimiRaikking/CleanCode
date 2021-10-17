package com.liv.test.algo.dp;

import com.liv.algo.dp.NumberOfArithmeticSlicesCal;
import org.junit.Assert;
import org.junit.Test;

public class NumberOfArithmeticSlicesCalTest {

    private static final NumberOfArithmeticSlicesCal cal = new NumberOfArithmeticSlicesCal();

    @Test
    public void test(){
        int[] nums = new int[]{1,2,3,4};
        Assert.assertEquals(cal.numberOfArithmeticSlices(nums), 3);
    }
}
