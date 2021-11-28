package com.liv.test.algo.dfs;

import com.liv.algo.dfs.MapSum;
import org.junit.Assert;
import org.junit.Test;

public class MapSumTest {

    private MapSum mapSum = new MapSum();

    @Test
    public void test(){
        mapSum.insert("apple", 3);
        mapSum.insert("app",2);
        Assert.assertEquals(3, mapSum.sum("apple"));
        Assert.assertEquals(5, mapSum.sum("ap"));
    }
}
