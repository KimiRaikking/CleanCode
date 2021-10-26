package com.liv.algo.backtrack;

import java.util.*;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer,List<String>> wordDictMap = new HashMap<>();
        Set<Character> letters = new HashSet<>();
        for(int i=0;i<wordDict.size();i++){
            String word = wordDict.get(i);
            for(char c: word.toCharArray()){
                letters.add(c);
            }
        }
        for(int i=0;i<s.length();i++){
            Character character = s.charAt(i);
            if(!letters.contains(character)){
                return false;
            }
        }
        wordDict.forEach(word -> wordDictMap.computeIfAbsent(word.length(), k -> new ArrayList<>()).add(word));
        List<Integer> wordDictLens = new ArrayList<>(wordDictMap.keySet());
        Collections.sort(wordDictLens, ((o1, o2) -> Integer.compare(o2,o1)));
        return dfs(s,wordDictMap,wordDictLens);
    }

    private boolean dfs(String s, Map<Integer,List<String>> wordDictMap,List<Integer> wordDictLens){
        if(wordDictMap.containsKey(s.length()) && wordDictMap.get(s.length()).contains(s)){
            return true;
        }
        // split s
        int len = s.length();
        for(int i=0;i<wordDictLens.size();i++){
            int wordLen = wordDictLens.get(i);
            if(wordLen > s.length()){
                continue;
            }
            String subS = s.substring(0,wordLen);
            if(wordDictMap.get(wordLen).contains(subS) && dfs(s.substring(wordLen, len),wordDictMap,wordDictLens)){
                return true;
            }
        }
        return false;
    }
}
