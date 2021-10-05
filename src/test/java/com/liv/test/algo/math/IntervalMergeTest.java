package com.liv.test.algo.math;

import com.liv.algo.math.IntervalMerge;
import org.junit.Assert;
import org.junit.Test;

public class IntervalMergeTest {

    @Test
    public void test(){
        IntervalMerge intervalMerge = new IntervalMerge();
        int[][] input = {{1,3},{2,6},{8,10},{15,18}};
        int[][] output = intervalMerge.merge(input);
        Assert.assertEquals(output[0][1], 6);
    }
}
