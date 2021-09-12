package com.liv.algo.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/***
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 示例 2：
 *
 * 输入：board = [["X"]]
 * 输出：[["X"]]
 *  
 *
 * 提示：
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 为 'X' 或 'O'
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SurroundRegionCal {

    public void solve(char[][] board) {
        if(null == board || board.length==0){
            return;
        }
        int n = board.length;
        int m = board[0].length;
        boolean[][] visitedOboard = new boolean[board.length][board[0].length];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 'O' && !visitedOboard[i][j]){
                    visitedOboard[i][j] = true;
                    handle(i,j,board,visitedOboard);
                }
            }
        }
    }

    public void solve1(char[][] board){
        if(null == board || board.length==0){
            return;
        }
        int n = board.length;
        int m = board[0].length;
        boolean[][] isEdgeConnect = new boolean[board.length][board[0].length];
        for(int i=0;i<m;i++){
            if(board[0][i] == 'O' && !isEdgeConnect[0][i]){
                isEdgeConnect[0][i]=true;
                findEdgeConnectCell(0,i,board,isEdgeConnect);
            }
            if(board[n-1][i] == 'O' && !isEdgeConnect[n-1][i]){
                isEdgeConnect[n-1][i]=true;
                findEdgeConnectCell(n-1,i,board,isEdgeConnect);
            }
        }
        for(int j=0;j<n;j++){
            if(board[j][0] == 'O' && !isEdgeConnect[j][0]){
                isEdgeConnect[j][0]=true;
                findEdgeConnectCell(j,0,board,isEdgeConnect);
            }
            if(board[j][m-1] == 'O' && !isEdgeConnect[j][m-1]){
                isEdgeConnect[j][m-1]=true;
                findEdgeConnectCell(j,m-1,board,isEdgeConnect);
            }
        }
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(board[i][j] == 'O' && !isEdgeConnect[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }


    private void findEdgeConnectCell(int i, int j, char[][] board, boolean[][] isEdgeConnect){
        if(i<0 || i> (board.length-1)){
            return;
        }
        if(j<0 || j> (board[0].length-1)){
            return;
        }
        // find all connected o cells
        Queue<Cell> queue = new ArrayDeque<>();
        Cell firstCell = new Cell(i,j,board[i][j]);
        queue.offer(firstCell);
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int index=0;index<len;index++){
                Cell cell = queue.poll();
                // add child cells
                List<Cell> children = getNextChildCells(cell, board,isEdgeConnect);
                for(Cell cell1: children){
                    queue.offer(cell1);
                }
            }
        }
    }

    private void handle(int i, int j, char[][] board, boolean[][] visited){
        if(i<0 || i> (board.length-1)){
            return;
        }
        if(j<0 || j> (board[0].length-1)){
            return;
        }
        // find all connected o cells
        List<Cell> childCells = new ArrayList<>();
        Queue<Cell> queue = new ArrayDeque<>();
        Cell firstCell = new Cell(i,j,board[i][j]);
        queue.offer(firstCell);
        boolean isConnectedEdge = false;
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int index=0;index<len;index++){
                Cell cell = queue.poll();
                childCells.add(cell);
                if(isCellInEdge(cell, board.length, board[0].length)){
                    isConnectedEdge = true;
                }
                // add child cells
                List<Cell> children = getNextChildCells(cell, board,visited);
                for(Cell cell1: children){
                    queue.offer(cell1);
                }
            }
        }
        if(!isConnectedEdge){
            for(Cell cell: childCells){
                board[cell.rowIndex][cell.colIndex] = 'X';
            }
        }

    }

    private boolean isCellInEdge(Cell cell, int n, int m){
        if(cell.rowIndex == 0 || cell.rowIndex == (n-1)){
            return true;
        }
        if(cell.colIndex == 0 || cell.colIndex == (m-1)){
            return true;
        }
        return false;
    }
    private List<Cell> getNextChildCells(Cell cur,char[][] board, boolean[][] visited){
        List<Cell> children = new ArrayList<>();
        int i = cur.rowIndex;
        int j = cur.colIndex;
        addCell(i-1, j, board, children, visited);
        addCell(i+1, j, board, children, visited);
        addCell(i, j-1, board, children, visited);
        addCell(i, j+1, board, children, visited);
        return children;
    }

    private void addCell(int i, int j, char[][] board, List<Cell> cells, boolean[][] visited){
        if(i<0|| i>=board.length){
            return;
        }
        if(j<0|| j>=board[0].length){
            return;
        }
        if(board[i][j] == 'O' && !visited[i][j]){
            cells.add(new Cell(i,j,board[i][j]));
            visited[i][j] = true;
        }
    }



    public static class Cell{
        private int rowIndex;

        private int colIndex;

        private char value;

        public Cell(int i, int j, char value){
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

        public char getValue() {
            return value;
        }

        public void setValue(char value) {
            this.value = value;
        }
    }
}
