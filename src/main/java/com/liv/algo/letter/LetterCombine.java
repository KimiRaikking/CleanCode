package com.liv.algo.letter;

import java.util.*;

public class LetterCombine {

    private static final Map<Character,List<Character>> dict = new HashMap<>();

    {
        dict.put('2', Arrays.asList(new Character[]{'a','b','c'}));
        dict.put('3', Arrays.asList(new Character[]{'d','e','f'}));
        dict.put('4', Arrays.asList(new Character[]{'g','h','i'}));
        dict.put('5', Arrays.asList(new Character[]{'j','k','l'}));
        dict.put('6', Arrays.asList(new Character[]{'m','n','o'}));
        dict.put('7', Arrays.asList(new Character[]{'p','q','r','s'}));
        dict.put('8', Arrays.asList(new Character[]{'t','u','v'}));
        dict.put('9', Arrays.asList(new Character[]{'w','x','y','z'}));
    }



    public void backTrack(List<String> combinations, StringBuffer combineStr, String digits, int index){
        if(null == digits || index == digits.length()){
            combinations.add(combineStr.toString());
        }else{
            Character character = digits.charAt(index++);
            if(!dict.containsKey(character)){
                backTrack(combinations, combineStr, digits, index);
            }else{
                List<Character> chars = dict.get(character);
                for(Character c : chars){
                    StringBuffer str = null;
                    if(null == combineStr){
                        str = new StringBuffer(c.toString());
                    }else{
                        str = new StringBuffer(combineStr.toString());
                        str.append(c);
                    }
                    backTrack(combinations, str, digits,index);
                }
            }
        }
    }

    public List<String> letterCombinations1(String digits){
        List<String> combinations = new ArrayList<>();
        if(null == digits || digits.length() == 0){
            return combinations;
        }
        backTrack(combinations,null,digits,0);
        return combinations;
    }


    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if(null == digits || digits.length() == 0){
            return combinations;
        }
        int length = digits.length();
        for(int i=0;i<length;i++){
            Character character = digits.charAt(i);
            if(!dict.containsKey(character)){
                continue;
            }
            if(i==0){
                dict.get(character).forEach(c -> combinations.add(String.valueOf(c)));
            }else{
                List<String> temp = new ArrayList<>(combinations);
                combinations.clear();
                dict.get(character).forEach(c -> {
                    temp.forEach(s -> {
                        String value = s + c;
                        combinations.add(value);
                    });
                });
            }
        }
        return combinations;
    }
}
