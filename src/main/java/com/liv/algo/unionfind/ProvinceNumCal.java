package com.liv.algo.unionfind;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/***
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 *
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 *
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 *
 * 返回矩阵中 省份 的数量。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 * 示例 2：
 *
 *
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 *  
 *
 * 提示：
 *
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] 为 1 或 0
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-provinces
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ProvinceNumCal {

    public int findCircleNum(int[][] isConnected){
        if(null == isConnected || isConnected.length == 0){
            return 0;
        }
        int[] fa = new int[isConnected.length];
        int[] rank = new int[isConnected.length];
        for (int i=0;i< isConnected.length;i++){
            fa[i] = i;
            rank[i] = 1;
        }
        for(int i=0;i< isConnected.length;i++){
            for(int j=0;j<isConnected[i].length;j++){
                if(isConnected[i][j] == 1){
                    merge(i,j,fa,rank);
                }
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<fa.length;i++){
            set.add(find(i,fa));
        }
        return set.size();
    }

    private void merge(int i, int j, int[] fa, int[] rank){
        int x= find(i,fa);
        int y = find(j, fa);
        if(x==y){
            return;
        }
        if(rank[x] <= rank[y]){
            fa[x] = y;
        }else{
            fa[y] = x;
        }
        if(rank[x] == rank[y]){
            rank[x]++;
            rank[y]++;
        }
    }

    private int find(int i, int[] fa){
        if(fa[i] == i){
            return i;
        }else{
            fa[i] = find(fa[i], fa);
            return fa[i];
        }
    }
}
