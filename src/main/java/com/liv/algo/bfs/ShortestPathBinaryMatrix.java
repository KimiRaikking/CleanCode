package com.liv.algo.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/***
 * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
 *
 * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
 *
 * 路径途经的所有单元格都的值都是 0 。
 * 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
 * 畅通路径的长度 是该路径途经的单元格总数。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[0,1],[1,0]]
 * 输出：2
 * 示例 2：
 *
 *
 * 输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
 * 输出：4
 * 示例 3：
 *
 * 输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
 * 输出：-1
 *  
 *
 * 提示：
 *
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 100
 * grid[i][j] 为 0 或 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-path-in-binary-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class ShortestPathBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(null == grid || grid.length == 0){
            return -1;
        }
        int n = grid.length;
        if(grid[0][0] != 0 || grid[n-1][n-1]!= 0){
            return -1;
        }
        int i=0;
        int j=0;
        int path=0;
        Queue<Cell> queue = new ArrayDeque<>();
        Cell firstCell = new Cell(i,j,grid[i][j]);
        // 将访问过的节点置1
        grid[i][j] = 1;
        queue.offer(firstCell);
        while(!queue.isEmpty()){
            path++;
            int length = queue.size();
            for(int index=0;index<length;index++){
                Cell cur = queue.poll();
                if(isEndCell(cur, grid)){
                    return path;
                }else{
                    // add new child cell to queue
                    List<Cell> childCells = getChildZeroCell(cur,grid);
                    for(Cell cell: childCells){
                        queue.offer(cell);
                    }
                }
            }
        }
        return -1;

    }

    private List<Cell> getChildZeroCell(Cell curCell, int[][] grid){
        int i = curCell.getRowIndex();
        int j = curCell.getColIndex();
        int length = grid.length;
        List<Cell> cells = new ArrayList<>();
        addCell(i-1,j-1,cells, grid);
        addCell(i-1,j,cells,grid);
        addCell(i-1,j+1,cells,grid);
        addCell(i,j-1,cells,grid);
        addCell(i,j+1,cells,grid);
        addCell(i+1,j-1, cells,grid);
        addCell(i+1,j,cells,grid);
        addCell(i+1, j+1,cells,grid);
        return cells;

    }

    private void addCell(int i, int j, List<Cell> cells, int[][] grid){
        if(i<0||i>= grid.length){
            return;
        }
        if(j<0 || j>= grid.length){
            return;
        }
        if(grid[i][j] == 1){
            return;
        }
        Cell cell = new Cell(i,j,grid[i][j]);
        cells.add(cell);
        grid[i][j] = 1;
    }

    private boolean isEndCell(Cell cell, int[][]grid){
        int length = grid.length;;
        if(cell.getRowIndex() == (length-1) && cell.getColIndex()==(length-1) && cell.getValue() ==0){
            return true;
        }else{
            return false;
        }
    }

    public static class Cell{
        private int rowIndex;

        private int colIndex;

        private int value;

        public Cell(int i, int j, int value){
            this.rowIndex = i;
            this.colIndex = j;
            this.value = value;
        }

        public int getRowIndex() {
            return rowIndex;
        }

        public void setRowIndex(int rowIndex) {
            this.rowIndex = rowIndex;
        }

        public int getColIndex() {
            return colIndex;
        }

        public void setColIndex(int colIndex) {
            this.colIndex = colIndex;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
