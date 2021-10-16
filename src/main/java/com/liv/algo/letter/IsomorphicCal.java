package com.liv.algo.letter;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/***
 * 205. 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 *
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 *
 *
 * 示例 1:
 *
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 示例 3：
 *
 * 输入：s = "paper", t = "title"
 * 输出：true
 *
 *
 * 提示：
 *
 * 可以假设 s 和 t 长度相同。
 */
public class IsomorphicCal {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> dict = new HashMap<>();
        if (null == s || null == t) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int len = s.length();
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < len; i++) {
            char leftChar = s.charAt(i);
            char rightChar = t.charAt(i);
            if (!dict.computeIfAbsent(leftChar, key -> {
                if(charSet.add(rightChar)){
                    return rightChar;
                }else{
                    return '\001';
                }
            }).equals(rightChar)) {
                return false;
            }
        }
        return true;
    }
}
