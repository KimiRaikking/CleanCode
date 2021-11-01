package com.liv.test.data;

import com.liv.data.RotateArray;
import org.junit.Assert;
import org.junit.Test;

public class RotataArrayTest {

    private RotateArray rotateArray = new RotateArray();

    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        rotateArray.rotate(nums, 2);
        Assert.assertArrayEquals(new int[]{5, 6, 1, 2, 3, 4}, nums);

    }

    @Test
    public void test1() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        rotateArray.rotate1(nums, 2);
        Assert.assertArrayEquals(new int[]{5, 6, 1, 2, 3, 4}, nums);
    }

    @Test
    public void test2() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        rotateArray.rotate2(nums, 2);
        Assert.assertArrayEquals(new int[]{5, 6, 1, 2, 3, 4}, nums);
    }
}
