package com.liv.test.algo.slidingwindow;

import com.liv.algo.slidingwindow.ContainDupNum;
import org.junit.Assert;
import org.junit.Test;

public class ContainDupNumTest {

    private ContainDupNum containDupNum = new ContainDupNum();

    @Test
    public void test(){
        int[] nums = new int[]{1,2,3,1};
        Assert.assertEquals(true,containDupNum.containsNearbyDuplicate(nums,3));
        Assert.assertEquals(false,containDupNum.containsNearbyDuplicate(nums,2));
        Assert.assertEquals(true,containDupNum.containsNearbyDuplicate1(nums,3));
        Assert.assertEquals(false,containDupNum.containsNearbyDuplicate1(nums,2));
    }
}
