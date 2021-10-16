package com.liv.test.algo.backtrack;

import com.liv.algo.backtrack.SumCombine;
import org.junit.Test;

import java.util.List;

public class SumCombineTest {

    private static final SumCombine sumCombine = new SumCombine();

    @Test
    public void test(){
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target =  8;
        List<List<Integer>> results = sumCombine.combinationSum2(candidates,target);
        System.out.println(results.size());
    }
}
