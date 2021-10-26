package com.liv.algo.slidingwindow;

/***
 * clean code 1022
 */
public class SubStringNums {

    public int calNums(String s, String key){
        int len = s.length();
        int left = 0;
        int result = 0;
        for(int right=1;right<len+1;right++){
            if(isSatisfied(left,right,s,key)){
                result +=len - right+1;
                while (++left<right && isSatisfied(left,right,s,key)){
                    result +=len - right+1;
                }
            }
        }
        return result;
    }

    private boolean isSatisfied(int left,int right, String s, String key){
        for(int i=0;i<key.length();i++){
            if(!s.substring(left,right).contains(String.valueOf(key.charAt(i)))){
                return false;
            }
        }
        return true;
    }


}
