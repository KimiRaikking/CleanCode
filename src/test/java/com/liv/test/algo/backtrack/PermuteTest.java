package com.liv.test.algo.backtrack;

import com.liv.algo.backtrack.Permute;
import org.junit.Assert;
import org.junit.Test;

public class PermuteTest {

    private Permute permute = new Permute();

    @Test
    public void test(){
        int[] nums = new int[]{1,2,3};
        Assert.assertEquals(6, permute.permute(nums).size());
    }
}
