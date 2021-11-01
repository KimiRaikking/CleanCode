package com.liv.algo.slidingwindow;

import java.util.*;


/***
 * 187. 重复的DNA序列
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 *
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 示例 2：
 *
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 105
 * s[i] 为 'A'、'C'、'G' 或 'T'
 */
public class RepeatingDnaSequence {

    public List<String> findRepeatedDnaSequences1(String s) {
        if(s.length()<=10){
            return new ArrayList<>();
        }
        int len = s.length();
        Set<String> res = new HashSet<>();
        Map<String,Integer> dnaSeqMap = new HashMap<>();
        for(int i=10;i<=len;i++){
            String subSeq = s.substring(i-10,i);
            dnaSeqMap.compute(subSeq, (k,v) -> {
                if(null==v){
                    v = 1;
                }else{
                    v++;
                    if(v==2){
                        res.add(k);
                    }
                }
                return v;
            });
        }
        return new ArrayList<>(res);
    }

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<>();
        if(s.length()<=10){
            return new ArrayList<>();
        }
        int len = s.length();
        int left=0;
        for(int right=10;right<=len;right++){
            while((right-left)>10 && left<= len)left++;
            if(res.contains(s.substring(left,right))){
                continue;
            }
            if(isSatisfied(left,right,s)){
                res.add(s.substring(left,right));
            }
        }
        return new ArrayList<>(res);
    }

    private boolean isSatisfied(int left,int right,String s){
        String subStr = s.substring(left,right);
        return s.substring(left+1).contains(subStr);
    }
}
