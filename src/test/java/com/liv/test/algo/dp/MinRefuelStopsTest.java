package com.liv.test.algo.dp;

import com.liv.algo.dp.MinRefuelStops;
import org.junit.Assert;
import org.junit.Test;

public class MinRefuelStopsTest {

    private MinRefuelStops minRefuelStops = new MinRefuelStops();

    @Test
    public void test(){
        int target = 100;
        int startFuel = 10;
        int[][] stations = new int[][]{{10,60},{20,30},{30,30},{60,40}};
        Assert.assertEquals(2, minRefuelStops.minRefuelStops(target,startFuel,stations));
        Assert.assertEquals(2, minRefuelStops.minRefuelStops1(target,startFuel,stations));
    }
}
