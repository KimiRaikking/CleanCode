package com.liv.algo.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/***
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *
 *
 * 示例 1:
 *
 *
 *
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 * 示例 2：
 *
 *
 *
 * 输入： heights = [2,4]
 * 输出： 4
 *
 *
 * 提示：
 *
 * 1 <= heights.length <=105
 * 0 <= heights[i] <= 104
 */
public class LargestRectangle {

    public int largestRectangleArea(int[] heights) {
        if(null == heights || heights.length==0){
            return 0;
        }
        if(heights.length==1){
            return heights[0];
        }
        List<Integer> tmpHeights = new ArrayList<>();
        for(int i=0;i<heights.length;i++){
            tmpHeights.add(heights[i]);
        }
        return backTrack(tmpHeights);
    }

    private int backTrack(List<Integer> heights){
        if(null == heights ||heights.size()==0){
            return 0;
        }
        if(heights.size()==1){
            return heights.get(0);
        }
        int minVal = Collections.min(heights);
        int maxVal = Collections.max(heights);
        int minIndex = heights.indexOf(minVal);
        int size = minVal* heights.size();
        if(minVal==maxVal){
            return size;
        }
        List<Integer> leftHeights = minIndex==0?new ArrayList<>():heights.subList(0,minIndex);
        List<Integer> rightHeights = minIndex==heights.size()-1?new ArrayList<>():heights.subList(minIndex+1,heights.size());
        return Math.max(size, Math.max(backTrack(leftHeights),backTrack(rightHeights)));
    }
}
