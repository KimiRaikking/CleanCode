package com.liv.test.algo.backtrack;

import com.liv.algo.backtrack.LargestRectangle;
import org.junit.Assert;
import org.junit.Test;

public class LargestRectangleTest {

    private static final LargestRectangle largestRec = new LargestRectangle();

    @Test
    public void test(){
        int[] heights = new int[]{2,1,5,6,2,3};
        int size = largestRec.largestRectangleArea(heights);
        Assert.assertEquals(10,size);
    }
}
