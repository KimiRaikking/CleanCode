package com.liv.algo.slidingwindow;

import java.util.*;

public class FindAnagrams {

    public List<Integer> findAnagrams1(String s, String p) {
        if(null == s || null == p || s.length()==0 || p.length()==0){
            return new ArrayList<>();
        }
        if(s.length() < p.length()){
            return new ArrayList<>();
        }
        int start = 0;
        int end = start+p.length();
        List<Integer> result = new ArrayList<>();
        char[] sortedP =p.toCharArray();
        Arrays.sort(sortedP);
        while(end <= s.length()){
            if(p.contains(String.valueOf(s.charAt(end-1)))){
                if(isAnagrams(s.substring(start, end), sortedP)){
                    result.add(start);
                }
            }
            start++;
            end++;
        }
        return result;
    }

    public List<Integer> findAnagrams(String s, String p){
        if(null == s || null == p || s.length()==0 || p.length()==0){
            return new ArrayList<>();
        }
        if(s.length() < p.length()){
            return new ArrayList<>();
        }
        int start = 0;
        int end = start+p.length()-1;
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> current = new HashMap<>();
        initMap(s,p,current,need);
        List<Integer> result = new ArrayList<>();
        while(end< s.length()){
            if(p.contains(String.valueOf(s.charAt(end)))){
                if(isAnagrams(current, need)){
                    result.add(start);
                }
            }
            // delete start char
            current.compute(s.charAt(start), (k,v)-> {
                if(v == 1){
                    return null;
                }else{
                    v--;
                    return v;
                }
            });
            start++;
            end++;
            if(end>=s.length()){
                break;
            }
            current.compute(s.charAt(end), (k,v)->{
                if(v == null){
                    v =1;
                }else{
                    v++;
                }
                return v;
            });
        }
        return result;

    }

    private void initMap(String s, String p, Map<Character,Integer>current, Map<Character,Integer> need){
        for(int i=0;i<p.length();i++){
            need.compute(p.charAt(i), (k,v) -> {
                if(null == v){
                    v = 1;
                }else{
                    v++;
                }
                return v;
            });
            current.compute(s.charAt(i), (k,v) -> {
                if(null == v){
                    v = 1;
                }else{
                    v++;
                }
                return v;
            });
        }
    }

    private boolean isAnagrams(Map<Character,Integer>cur, Map<Character,Integer> need){
        if(cur.size() != need.size()){
            return false;
        }
        for(Map.Entry<Character,Integer> entry: need.entrySet()){
            Integer curVal = cur.get(entry.getKey());
            if(!entry.getValue().equals(curVal)){
                return false;
            }
        }
        return true;
    }

    private boolean isAnagrams(String a, char[] sortedChars){
        char[] sortedComparingChars = a.toCharArray();
        Arrays.sort(sortedComparingChars);
        for(int i=0;i<sortedChars.length;i++){
            if(sortedComparingChars[i] != sortedChars[i]){
                return false;
            }
        }
        return true;
    }
}
