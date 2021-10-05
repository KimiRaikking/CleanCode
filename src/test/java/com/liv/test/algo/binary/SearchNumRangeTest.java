package com.liv.test.algo.binary;

import com.liv.algo.binary.SearchNumRange;
import com.liv.algo.binary.SearchSortedDupNumRange;
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

    @Test
    public void testSortedDupRangeSearch(){
        int[] nums = new int[]{1,4};
        int target = 4;
        SearchSortedDupNumRange searchNumRange = new SearchSortedDupNumRange();
        Assert.assertArrayEquals(new int[]{1, 1}, searchNumRange.searchRange(nums, target));
    }

    @Test
    public void testSortedDupRangeSearch1(){
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 6;
        SearchSortedDupNumRange searchNumRange = new SearchSortedDupNumRange();
        Assert.assertArrayEquals(new int[]{-1, -1}, searchNumRange.searchRange(nums, target));
    }
}
