package com.liv.test.algo.sort;

import com.liv.algo.sort.NextPermutation;
import org.junit.Assert;
import org.junit.Test;

public class NextPermutationTest {

    private NextPermutation nextPermutation = new NextPermutation();

    @Test
    public void test(){
        int[] nums = new int[]{1,2,3};
        nextPermutation.nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{1,3,2}, nums);
    }

    @Test
    public void test1(){
        int[] nums = new int[]{3,2,1};
        nextPermutation.nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{1,2,3}, nums);
    }

    @Test
    public void test2(){
        int[] nums = new int[]{2,3,1};
        nextPermutation.nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{3,1,2}, nums);
    }
}
