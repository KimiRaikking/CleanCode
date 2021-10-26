package com.liv.algo.template;

public class SlidingWindowTpl {

    public void method(String s){
        int left=0;
        int len = s.length();
        for(int right=0;right<len;right++){
            if(isSatisfied(left,right,s)){
                // do result process
            }else{
                // move left until satisfied or left == right
                while(++left<=right && !isSatisfied(left,right,s));
            }
        }
    }

    private boolean isSatisfied(int left,int right,String s){
        return true;
    }
}
