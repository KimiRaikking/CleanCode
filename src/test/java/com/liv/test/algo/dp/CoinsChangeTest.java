package com.liv.test.algo.dp;

import com.liv.algo.dp.CoinsChange;
import org.junit.Assert;
import org.junit.Test;

public class CoinsChangeTest {

    private static final CoinsChange coinsChange = new CoinsChange();


    @Test
    public void test(){
        int[] coins = new int[]{1,2,5};
        int amount = 11;
        Assert.assertEquals(3, coinsChange.coinChange(coins,amount));
    }
}
