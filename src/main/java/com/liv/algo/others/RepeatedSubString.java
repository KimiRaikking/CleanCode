package com.liv.algo.others;

/***
 * 459. 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 示例 1:
 *
 * 输入: "abab"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 *
 * 输入: "aba"
 *
 * 输出: False
 * 示例 3:
 *
 * 输入: "abcabcabcabc"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
public class RepeatedSubString {

    public boolean repeatedSubstringPattern(String s) {
        if(null == s|| s.length()==0){
            return false;
        }

        int len = s.length();
        int longestSubLen = len/2;
        for(int i=longestSubLen;i>=1;i--){
            if(len%i != 0){
                continue;
            }
            if(isRepeatedSubStr(s,i)){
                return true;
            }
        }
        return false;
    }

    private boolean isRepeatedSubStr(String s, int sublen){
        String subStr = s.substring(0,sublen);
        for(int i=sublen;i<s.length();i+=sublen){
            if(!subStr.equals(s.substring(i,i+sublen))){
                return false;
            }
        }
        return true;
    }
}
