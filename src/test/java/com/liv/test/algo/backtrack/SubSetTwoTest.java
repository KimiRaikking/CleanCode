package com.liv.test.algo.backtrack;

import com.liv.algo.backtrack.SubSetTwo;
import org.junit.Assert;
import org.junit.Test;

public class SubSetTwoTest {

    private static final SubSetTwo subSetTwo = new SubSetTwo();

    @Test
    public void test(){
        int[] nums = new int[]{1,2,2};
        Assert.assertEquals(subSetTwo.subsetsWithDup(nums).size(), 6);
    }

    @Test
    public void test1(){
        int[] nums = new int[]{1,2,2};
        Assert.assertEquals(subSetTwo.subsetsWithDup1(nums), 6);
    }
}
