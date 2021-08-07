package com.liv.algo.doublepoint;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * 给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而 secondList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。
 *
 * 返回这 两个区间列表的交集 。
 *
 * 形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b 。
 *
 * 两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
 * 输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * 示例 2：
 *
 * 输入：firstList = [[1,3],[5,9]], secondList = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：firstList = [], secondList = [[4,8],[10,12]]
 * 输出：[]
 * 示例 4：
 *
 * 输入：firstList = [[1,7]], secondList = [[3,10]]
 * 输出：[[3,7]]
 *  
 *
 * 提示：
 *
 * 0 <= firstList.length, secondList.length <= 1000
 * firstList.length + secondList.length >= 1
 * 0 <= starti < endi <= 109
 * endi < starti+1
 * 0 <= startj < endj <= 109
 * endj < startj+1
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/interval-list-intersections
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntervalInterSections {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (null == firstList || firstList.length == 0) {
            return new int[0][0];
        }
        if (null == secondList || secondList.length == 0) {
            return new int[0][0];
        }
        List<int[]> res = new ArrayList<>();
        int firstPoint = 0;
        int secondPoint = 0;
        while (firstPoint < firstList.length && secondPoint < secondList.length) {
            int firstStart = firstList[firstPoint][0];
            int firstEnd = firstList[firstPoint][1];
            int secondStart = secondList[secondPoint][0];
            int secondEnd = secondList[secondPoint][1];
            if (secondStart <= firstEnd) {
                if (secondEnd < firstStart) {
                    secondPoint++;
                } else if (secondEnd <= firstEnd) {
                    res.add(new int[]{Math.max(firstStart, secondStart), secondEnd});
                    secondPoint++;
                } else {
                    res.add(new int[]{Math.max(firstStart,secondStart), firstEnd});
                    firstPoint++;
                }
            } else if (secondStart > firstEnd) {
                firstPoint++;
            }
        }
        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
