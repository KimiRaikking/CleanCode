package com.liv.algo.sort;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/***
 * 451. 根据字符出现频率排序
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1:
 *
 * 输入:
 * "tree"
 *
 * 输出:
 * "eert"
 *
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 *
 * 输入:
 * "cccaaa"
 *
 * 输出:
 * "cccaaa"
 *
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 *
 * 输入:
 * "Aabb"
 *
 * 输出:
 * "bbAa"
 *
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 */
public class CharFreqSort {

    public String frequencySort(String s) {
        Map<Character,Integer> freqMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            freqMap.compute(c, (k,v)->{
                if(v==null){
                    v=1;
                }else{
                    v++;
                }
                return v;
            });
        }
        List<Map.Entry<Character,Integer>> entrySortedList =
        freqMap.entrySet().stream().sorted((e1,e2)->{
            if(e1.getValue() == e2.getValue()){
                return e1.getKey() - e2.getKey();
            }else{
                return Integer.compare(e2.getValue(),e1.getValue());
            }
        }).collect(Collectors.toList());
        String result = "";
        for(int i=0;i<entrySortedList.size();i++){
            Map.Entry<Character,Integer> entry = entrySortedList.get(i);
            String tmp = buildChars(entry.getKey(),entry.getValue());
            result = result + tmp;
        }
        return result;
    }

    private String buildChars(Character character, int num){
        String s = "";
        for(int i=0;i<num;i++){
            s += String.valueOf(character);
        }
        return s;
    }
}
