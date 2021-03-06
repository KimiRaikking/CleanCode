package com.liv.test.algo.doublepoint;

import com.liv.algo.doublepoint.ThreeSum;
import org.junit.Test;

public class ThreeSumTest {

    @Test
    public void testThreeSum(){
        int[] sums = new int[]{34,55,79,28,46,33,2,48,31,-3,84,71,52,-3,93,15,21,-43,57,-6,86,56,94,74,83,-14,28,-66,46,-49,62,-11,43,65,77,12,47,61,26,1,13,29,55,-82,76,26,15,-29,36,-29,10,-70,69,17,49};
        ThreeSum threeSum = new ThreeSum();
        threeSum.threeSum(sums);
    }

    @Test
    public void testThreeSum1(){
        int[] sums = new int[]{34,55,79,28,46,33,2,48,31,-3,84,71,52,-3,93,15,21,-43,57,-6,86,56,94,74,83,-14,28,-66,46,-49,62,-11,43,65,77,12,47,61,26,1,13,29,55,-82,76,26,15,-29,36,-29,10,-70,69,17,49};
        ThreeSum threeSum = new ThreeSum();
        threeSum.threeSum1(sums);
    }

    @Test
    public void testThreeSum2(){
        int[] sums = new int[]{-1,0,1,2,-1,-4};
        ThreeSum threeSum = new ThreeSum();
        threeSum.threeSum1(sums);
    }
}
