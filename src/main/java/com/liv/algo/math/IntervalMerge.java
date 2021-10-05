package com.liv.algo.math;

import java.util.*;

/***
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *  
 *
 * 提示：
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntervalMerge {

    public int[][] merge(int[][] intervals) {
        List<Interval> oriIntervals = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            if(intervals[i].length == 2){
                oriIntervals.add(new Interval(intervals[i][0], intervals[i][1]));
            }
        }
        oriIntervals.sort((Comparator.comparingInt(o -> o.start)));
        Stack<Interval> sortedIntervals = new Stack<>();
        for(int i=0;i<oriIntervals.size();i++){
            if(sortedIntervals.isEmpty()){
                sortedIntervals.add(oriIntervals.get(i));
            }else{
                Interval oriInterval = sortedIntervals.pop();
                Interval mergedInterval = mergeInterval(oriInterval, oriIntervals.get(i));
                if(null == mergedInterval){
                    sortedIntervals.add(oriInterval);
                    sortedIntervals.add(oriIntervals.get(i));
                }else{
                    sortedIntervals.add(mergedInterval);
                }
            }
        }

        int[][] result = new int[sortedIntervals.size()][2];
        int index = sortedIntervals.size()-1;
        while (!sortedIntervals.isEmpty()){
            Interval interval = sortedIntervals.pop();
            result[index][0] = interval.start;
            result[index][1] = interval.end;
            index--;
        }
        return result;
    }

    private Interval mergeInterval(Interval ori, Interval cur){
        if(cur.start > ori.end){
            return null;
        }
        Interval mergedInterval = cur.end> ori.end? new Interval(ori.start,cur.end): new Interval(ori.start, ori.end);
        return mergedInterval;
    }

    public static class Interval{
        private int start;
        private int end;

        public Interval(int left,int right){
            this.start = left;
            this.end=right;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }
}
