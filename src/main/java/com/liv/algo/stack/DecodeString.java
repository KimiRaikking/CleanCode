package com.liv.algo.stack;

import java.util.ArrayDeque;
import java.util.Stack;

/***
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 *
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 *
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 *
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 * 通过次数125,184提交次数226,343
 */
public class DecodeString {

    public String decodeString(String s) {
        if (null == s || s.length() == 0) {
            return "";
        }
        int len = s.length();
        ArrayDeque<String> stack = new ArrayDeque<>();
        int tmpNum = 0;
        for (int i = 0; i < len; i++) {
            char cur = s.charAt(i);
            if (cur == ']') {
                String temp = "";
                String block = "";
                while (!stack.isEmpty()) {
                    String str = stack.poll();
                    if (str.equals("[")) {
                        String num = stack.poll();
                        int count = Integer.parseInt(num);
                        while (count > 0) {
                            count--;
                            block += temp;
                        }
                        break;
                    } else {
                        temp = str + temp;
                    }
                }
                stack.push(block);
            } else if (cur >= '0' && cur <= '9') {
                if (s.charAt(i + 1) == '[') {
                    int num = tmpNum * 10 + (cur - '0');
                    stack.push(String.valueOf(num));
                    tmpNum = 0;
                } else {
                    tmpNum = 10 * tmpNum + (cur - '0');
                }
            } else {
                stack.push(String.valueOf(cur));
            }
        }
        String result = "";
        while (!stack.isEmpty()) {
            String tmp = stack.poll();
            result = tmp + result;
        }
        return result;
    }
}
