package com.liv.test.algo.math;


import java.util.*;

/***
 *
 */
public class FirstKNums {

    public int[] topKFrequent1(int[] nums, int k){
        if(k<=0){
            return new int[0];
        }
        int[] result = new int[k];
        Map<Integer,Integer> numCountMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            numCountMap.compute(nums[i], (key,v)-> {
                if(null ==v){
                    v=1;
                }else{
                    v++;
                }
                return v;
            });
        }
        List<NumCount> numCounts = new ArrayList<>();
        numCountMap.forEach((key,value)-> {
            numCounts.add(new NumCount(key,value));
        });
        PriorityQueue<NumCount> queue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.count,o2.count)));
        for(int i=0;i<numCounts.size();i++){
            if(queue.size()<k){
                queue.offer(numCounts.get(i));
            }else{
                if(queue.peek().count< numCounts.get(i).count){
                    queue.poll();
                    queue.offer(numCounts.get(i));
                }
            }
        }
        int i=0;
        while(!queue.isEmpty()){
            result[i++] = queue.poll().val;
        }
        return result;
    }

    public int[] topKFrequent(int[] nums, int k) {
        if(k<=0){
            return new int[0];
        }
        int[] result = new int[k];
        Map<Integer,Integer> numCountMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            numCountMap.compute(nums[i], (key,v)-> {
                if(null ==v){
                    v=1;
                }else{
                    v++;
                }
                return v;
            });
        }
        List<NumCount> numCounts = new ArrayList<>();
        numCountMap.forEach((key,value)-> {
            numCounts.add(new NumCount(key,value));
        });
        numCounts.sort((o1,o2)->Integer.compare(o2.count,o1.count));
        for(int i=0;i<Math.min(k,numCounts.size());i++){
            result[i] = numCounts.get(i).val;
        }
        return result;
    }

    private static class NumCount{
        private int val;

        private int count;

        public NumCount(int val,int count){
            this.val = val;
            this.count = count;
        }
    }
}
