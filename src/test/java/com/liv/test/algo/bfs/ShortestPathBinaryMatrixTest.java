package com.liv.test.algo.bfs;

import com.liv.algo.bfs.ShortestPathBinaryMatrix;
import org.junit.Assert;
import org.junit.Test;

public class ShortestPathBinaryMatrixTest {

    @Test
    public void testGrid1(){
        int[][] grid = new int[][]{{0,1},{1,0}};
        ShortestPathBinaryMatrix shortestPathBinaryMatrix = new ShortestPathBinaryMatrix();
        Assert.assertEquals(2, shortestPathBinaryMatrix.shortestPathBinaryMatrix(grid));
    }

    @Test
    public void testTripleGrid(){
        int[][] grid = new int[][]{{0,1},{1,0}};
        ShortestPathBinaryMatrix shortestPathBinaryMatrix = new ShortestPathBinaryMatrix();
        Assert.assertEquals(4, shortestPathBinaryMatrix.shortestPathBinaryMatrix(grid));
    }
}
