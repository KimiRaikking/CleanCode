package com.liv.test.algo.backtrack;

import com.liv.algo.backtrack.SubSetOne;
import org.junit.Assert;
import org.junit.Test;

public class SubSetOneTest {

    private static final SubSetOne subSetOne = new SubSetOne();

    @Test
    public void test(){
        int[] nums = new int[]{1,2,3};
        Assert.assertEquals(8, subSetOne.subsets(nums).size());
    }

    @Test
    public void test1(){
        int[] nums = new int[]{1,2,3};
        Assert.assertEquals(8, subSetOne.subsets1(nums).size());
    }
}
