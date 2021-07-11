package com.liv.test.algo.binary;

import com.liv.algo.binary.SearchNumRange;
import org.junit.Assert;
import org.junit.Test;

public class SearchNumRangeTest {

    @Test
    public void testRangeSearch(){
        int[] nums = new int[]{1,4};
        int target = 4;
        SearchNumRange searchNumRange = new SearchNumRange();
        Assert.assertArrayEquals(new int[]{1, 1}, searchNumRange.searchRange(nums, target));
    }
}
