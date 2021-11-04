package com.liv.algo.graph;

import java.util.*;

public class CourseSheetTwo {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> nodeMap = new HashMap<>();
        int[] inDegree = new int[numCourses];
        int maxInDegree = 0;
        for(int i=0;i< prerequisites.length;i++){
            int[] prerequisit = prerequisites[i];
            nodeMap.computeIfAbsent(prerequisit[1], key->new ArrayList<>()).add(prerequisit[0]);
            inDegree[prerequisit[0]]++;
            maxInDegree = Math.max(maxInDegree,inDegree[prerequisit[0]]);
        }
        List<Integer> orders = new ArrayList<>();
        Queue<Integer> zeroDegrees = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                zeroDegrees.add(i);
            }
        }
        while(!zeroDegrees.isEmpty()){
            int count = zeroDegrees.size();
            for(int i=0;i<count;i++){
                int num = zeroDegrees.poll();
                orders.add(num);
                List<Integer> outNodes = nodeMap.getOrDefault(num, new ArrayList<>());
                for(int outNode:outNodes){
                    inDegree[outNode]--;
                    if(inDegree[outNode] == 0){
                        zeroDegrees.add(outNode);
                    }
                }
            }
        }

        if(orders.size() == numCourses){
            int[] res = new int[numCourses];
            for(int i=0;i<numCourses;i++){
                res[i] = orders.get(i);
            }
            return res;
        }else{
            return new int[0];
        }
    }
}
