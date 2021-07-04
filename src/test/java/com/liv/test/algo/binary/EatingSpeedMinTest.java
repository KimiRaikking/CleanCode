package com.liv.test.algo.binary;

import com.liv.algo.binary.EatingSpeedMin;
import org.junit.Test;

public class EatingSpeedMinTest {

    @Test
    public void testSpeed(){
        int[] piles = {3,6,7,11};
        int h = 8;
        EatingSpeedMin eatingSpeedMin = new EatingSpeedMin();
        eatingSpeedMin.minEatingSpeed(piles,h);
     }
}
