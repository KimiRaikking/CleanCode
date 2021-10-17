package com.liv.test.algo.dfs;

import com.liv.algo.dfs.FindAllPath;
import org.junit.Assert;
import org.junit.Test;

public class FindAllPathTest {

    private static final FindAllPath findAllPath = new FindAllPath();

    @Test
    public void test(){
        int[][]graph = new int[][]{{1,2},{3},{3},{}};
        Assert.assertEquals(2,findAllPath.allPathsSourceTarget(graph).size());
    }
}
