package com.liv.data;

import java.util.ArrayDeque;
import java.util.Queue;

public class RecentCounter {

    private Queue<Integer> recentCounterQueue ;

    public RecentCounter() {
        recentCounterQueue = new ArrayDeque<>();
    }

    public int ping(int t) {
        recentCounterQueue.add(t);
        while (!recentCounterQueue.isEmpty() && recentCounterQueue.peek()<(t-3000)){
            recentCounterQueue.poll();
        }
        return recentCounterQueue.size();
    }
}
