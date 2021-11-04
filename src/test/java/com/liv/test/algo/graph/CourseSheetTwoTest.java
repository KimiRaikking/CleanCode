package com.liv.test.algo.graph;

import com.liv.algo.graph.CourseSheetTwo;
import org.junit.Assert;
import org.junit.Test;

public class CourseSheetTwoTest {

    private CourseSheetTwo courseSheetTwo = new CourseSheetTwo();

    @Test
    public void test(){
        int[][] pres = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        Assert.assertArrayEquals(new int[]{0,1,2,3}, courseSheetTwo.findOrder(4,pres));
        int[][] pres1 = new int[][]{{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}};
        Assert.assertArrayEquals(new int[]{6,5,4,2,3,0,1}, courseSheetTwo.findOrder(7,pres1));
    }
}
