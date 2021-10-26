package com.liv.test.algo.slidingwindow;

import com.liv.algo.slidingwindow.ContainAlmostNearNum;
import org.junit.Assert;
import org.junit.Test;

public class ContainAlmostNearNumTest {

    private ContainAlmostNearNum containAlmostNearNum = new ContainAlmostNearNum();

    @Test
    public void test(){
        int[] nums = new int[]{1,5,9,1,5,9};
        Assert.assertEquals(false,containAlmostNearNum.containsNearbyAlmostDuplicate(nums,2,3));
        Assert.assertEquals(true,containAlmostNearNum.containsNearbyAlmostDuplicate(nums,2,4));
        int[] nums1 = new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE};
        Assert.assertEquals(false, containAlmostNearNum.containsNearbyAlmostDuplicate(nums1,1,1));
        int[] nums2 = new int[]{4,1,6,3};
        Assert.assertEquals(true,containAlmostNearNum.containsNearbyAlmostDuplicate(nums2,100,1));
    }
}
