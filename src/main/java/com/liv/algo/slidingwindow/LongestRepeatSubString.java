package com.liv.algo.slidingwindow;

public class LongestRepeatSubString {

    public int longestRepeatingSubstring(String s) {
        int len = s.length();
        if(len==0){
            return 0;
        }
        int left=0;
        int result = 0;
        for(int right=0;right<len;right++){
            if(isReatSubStr(left,right,s)){
                result = Math.max(result,right-left+1);
            }else{
                while(++left<=right && !isReatSubStr(left,right,s));
            }
        }
        return result;

    }

    private boolean isReatSubStr(int start,int end,String s){
        return s.substring(start+1).contains(s.substring(start,end+1));
    }
}
