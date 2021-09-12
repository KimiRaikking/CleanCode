package com.liv.test.algo.bfs;

import com.liv.algo.bfs.SurroundRegionCal;
import org.junit.Test;

public class SurroundRegionCalTest {

    @Test
    public void testSurroundRegion(){
        char[][] board = new char[][]{{'O','O','O'},{'O','O','O'},{'O','O','O'}};
        SurroundRegionCal cal = new SurroundRegionCal();
        cal.solve(board);
    }

    @Test
    public void testSurroundRegion1(){
        char[][] board = new char[][]{{'O','X','O','O','O','X'},{'O','O','X','X','X','O'},{'X','X','X','X','X','O'},{'O','O','O','O','X','X'},{'X','X','O','O','X','O'},{'O','O','X','X','X','X'}};

        SurroundRegionCal cal = new SurroundRegionCal();
        cal.solve1(board);
    }
}
