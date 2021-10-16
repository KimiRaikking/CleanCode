package com.liv.test.algo.dp;

import com.liv.algo.dp.MaxSlidingWindow;
import org.junit.Assert;
import org.junit.Test;

public class MaxSlidingWindowTest {

    private static final MaxSlidingWindow maxSlidingWindow =  new MaxSlidingWindow();

    @Test
    public void test(){
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k=3;
        Assert.assertArrayEquals(new int[]{3,3,5,5,6,7}, maxSlidingWindow.maxSlidingWindow(nums,k));
    }

    @Test
    public void test1(){
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k=3;
        Assert.assertArrayEquals(new int[]{3,3,5,5,6,7}, maxSlidingWindow.maxSlidingWindow1(nums,k));
    }

    @Test
    public void test2(){
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k=3;
        Assert.assertArrayEquals(new int[]{3,3,5,5,6,7}, maxSlidingWindow.maxSlidingWindow2(nums,k));
    }
}
