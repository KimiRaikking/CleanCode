package com.liv.algo.binary;


/***
 * 875. 爱吃香蕉的珂珂
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 *
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 *
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 *
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 *
 *
 *
 * 示例 1：
 *
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 * 示例 2：
 *
 * 输入: piles = [30,11,23,4,20], H = 5
 * 输出: 30
 * 示例 3：
 *
 * 输入: piles = [30,11,23,4,20], H = 6
 * 输出: 23
 *
 *
 * 提示：
 *
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 */
public class EatingSpeedMin {

    public int minEatingSpeed(int[] piles, int h) {
        int pilesMin = Integer.MAX_VALUE;
        int pilesMax = 0;
        for(int i=0;i<piles.length;i++){
            pilesMax = Math.max(pilesMax, piles[i]);
            pilesMin = Math.min(pilesMin, piles[i]);
        }

        int left = (int) Math.ceil(pilesMin / ((h/piles.length)*1.0));
        int right = pilesMax;

        while(left< right){
            int mid = (left+right)/2;
            int time = eatingTime(piles, mid);
            if(time > h){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    private int eatingTime(int[] piles,int speed){
        int time = 0;
        for(int i=0;i<piles.length;i++){
            time += Math.ceil(piles[i]/(speed*1.0));
        }
        return time;
    }
}
