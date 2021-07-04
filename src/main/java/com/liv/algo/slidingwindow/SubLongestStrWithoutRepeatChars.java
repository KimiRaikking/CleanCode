package com.liv.algo.slidingwindow;


import java.util.HashMap;
import java.util.Map;

/***
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubLongestStrWithoutRepeatChars {

    public int lengthOfLongestSubstring(String s) {
        if(null == s || s.isEmpty()){
            return 0;
        }
        if(s.length()<=1){
            return 1;
        }
        int length = s.length();
        int longestSubStrLength=0;
        for(int i=0;i<length;i++){
            if((length-i)<longestSubStrLength){
                break;
            }
            Map<Character, Integer> charMap = new HashMap<>();
            int tempLength=0;
            for(int j=i;j<length;j++){
                if(charMap.containsKey(s.charAt(j))){
                    break;
                }else{
                    tempLength++;
                    charMap.put(s.charAt(j), 1);
                }
            }
            longestSubStrLength = Math.max(longestSubStrLength, tempLength);
        }
        return longestSubStrLength;

    }

    public int lengthOfLongestSubstring1(String s){
        Map<Character,Integer> charMap = new HashMap<>();
        int length = s.length();
        int longestLength=0;
        for(int start=0,end=0;end<length;end++){
            Character curChar = s.charAt(end);
            if(charMap.containsKey(curChar)){
                start = Math.max(start, charMap.get(curChar)+1);
            }
            charMap.put(curChar, end);
            longestLength = Math.max(longestLength, end-start+1);
        }
        return longestLength;
    }

    public static void main(String[] args) {
        String a = "abba";
        SubLongestStrWithoutRepeatChars subLongestStrWithoutRepeatChars = new SubLongestStrWithoutRepeatChars();
        System.out.println(subLongestStrWithoutRepeatChars.lengthOfLongestSubstring1(a));
    }
}
