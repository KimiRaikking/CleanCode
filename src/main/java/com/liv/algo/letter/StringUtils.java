package com.liv.algo.letter;

public class StringUtils {


    /***
     * 709. 转换成小写字母
     * 给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "Hello"
     * 输出："hello"
     * 示例 2：
     *
     * 输入：s = "here"
     * 输出："here"
     * 示例 3：
     *
     * 输入：s = "LOVELY"
     * 输出："lovely"
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 100
     * s 由 ASCII 字符集中的可打印字符组成
     * @param s
     * @return
     */
    public String toLowerCase(String s) {
        if(null == s || s.length()==0){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char letter = s.charAt(i);
            if(letter>='A' && letter<='Z'){
                // ascii 码表 大小写差32，且正好可以按照位或操作转换，这也是为什么大小写字母在ascii中不连续
                letter |=32;
            }
            sb.append(letter);
        }
        return sb.toString();
    }
}
