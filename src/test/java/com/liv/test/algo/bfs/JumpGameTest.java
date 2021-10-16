package com.liv.test.algo.bfs;

import com.liv.algo.bfs.JumpGame;
import com.liv.algo.greedy.GreedyJumpGame;
import org.junit.Assert;
import org.junit.Test;

public class JumpGameTest {

    private static final JumpGame jumpGame = new JumpGame();

    private static final GreedyJumpGame greedyJumpGame = new GreedyJumpGame();

    @Test
    public void test(){
        int[] nums = new int[]{2,3,1,1,4};
        int jump = jumpGame.jump(nums);
        Assert.assertEquals(2, jump);
    }

    @Test
    public void test1(){
        int[] nums = new int[]{2,3,1,1,4};
        int jump = greedyJumpGame.jump(nums);
        Assert.assertEquals(2, jump);
    }
}
