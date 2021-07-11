package com.liv.test.algo.binary;

import com.liv.algo.binary.SearchRotateNumsCal;
import org.junit.Assert;
import org.junit.Test;

public class SearchRotateNumsCalTest {

    @Test
    public void testSearchNum1(){
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        SearchRotateNumsCal cal = new SearchRotateNumsCal();
        Assert.assertEquals(4, cal.search(nums, target));
    }

    @Test
    public void testSearchNum2(){
        int[] nums = new int[]{4,5,6,7,8,1,2,3};
        int target = 8;
        SearchRotateNumsCal cal = new SearchRotateNumsCal();
        Assert.assertEquals(4, cal.search(nums, target));
    }
}
