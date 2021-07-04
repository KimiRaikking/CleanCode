package com.liv.algo.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/***
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubLongestPalindrome {

    public String longestPalindrome(String s) {
        if(null == s || s.length()<2){
            return s;
        }
        int length = s.length();
        int maxLengthStart=0;
        int maxLengthEnd =0;

        boolean[][]dp = new boolean[length][length];
        dp[0][0]=true;
        for(int r=1;r<length;r++){
            for(int l=0;l<r;l++){
                if(s.charAt(l)==s.charAt(r) && (r-l<=2 ||dp[l+1][r-1])){
                    dp[l][r] = true;
                    if((r-l+1)> (maxLengthEnd-maxLengthStart+1)){
                        maxLengthStart=l;
                        maxLengthEnd=r;
                    }
                }
            }
        }
        return s.substring(maxLengthStart, maxLengthEnd+1);
    }
}
