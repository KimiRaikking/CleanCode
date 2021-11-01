package com.liv.algo.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/***
 * 159. 至多包含两个不同字符的最长子串
 * 给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t ，并返回该子串的长度。
 *
 * 示例 1:
 *
 * 输入: "eceba"
 * 输出: 3
 * 解释: t 是 "ece"，长度为3。
 * 示例 2:
 *
 * 输入: "ccaabbb"
 * 输出: 5
 * 解释: t 是 "aabbb"，长度为5。
 */
public class LongestSubstringTwoDistinct {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(null == s){
            return 0;
        }
        if(s.length()<=2){
            return s.length();
        }
        int len = s.length();
        int left=0;
        Map<Character,Integer> charMap = new HashMap<>();
        charMap.put(s.charAt(0),1);
        int res=0;
        int right = 1;
        for(;right<len;right++){
            Character newChar = s.charAt(right);
            charMap.compute(newChar, (k,v)->{
                if(v==null){
                    v=1;
                }else{
                    v++;
                }
                return v;
            });
            if(!isSatisfied(charMap)){
                res = Math.max(res, (right-left));
            }
            while(!isSatisfied(charMap) && left<right){
                charMap.compute(s.charAt(left), (k,v)->{
                    if(v==1){
                        v =null;
                    }else{
                        v--;
                    }
                    return v;
                });
                left++;
            }
        }
        res = Math.max(res, right-left+1);
        return res;
    }

    private boolean isSatisfied(Map<Character,Integer> charMap){
        return charMap.size()<=2;
    }
}
