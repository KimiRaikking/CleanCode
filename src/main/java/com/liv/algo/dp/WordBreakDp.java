package com.liv.algo.dp;

import java.util.*;

public class WordBreakDp {

    public boolean wordBreak(String s, List<String> wordDict){
        Map<Integer,List<String>> wordDictMap = new TreeMap<>();
        wordDict.forEach(word -> wordDictMap.computeIfAbsent(word.length(), k -> new ArrayList<>()).add(word));
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        List<Integer> lenKeys = new ArrayList<>(wordDictMap.keySet());
        Collections.sort(lenKeys);
        for(int i=lenKeys.get(0);i<=len;i++){
            for(Map.Entry<Integer,List<String>> entry: wordDictMap.entrySet()){
                int curWordLen = entry.getKey();
                if(i>=curWordLen && dp[i-curWordLen] && entry.getValue().contains(s.substring(i-curWordLen,i))){
                    dp[i] = true;
                }
            }
        }
        return dp[len];
    }
}
