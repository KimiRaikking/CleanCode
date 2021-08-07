package com.liv.algo.doublepoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 *
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 *
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 *
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *  
 *
 * 提示：
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 *  
 *
 * 进阶：
 *
 * 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/backspace-string-compare
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BackSpaceCompare {

    public boolean backspaceCompare(String s, String t) {
        return generateChars(s).equals(generateChars(t));
    }

    private String generateChars(String s){
        char[] chars = s.toCharArray();
        int left = 0;
        List<Character> realChars = new ArrayList<>();
        for(int i=0;i<chars.length;i++){
            char curChar = chars[i];
            if(curChar != '#'){
                realChars.add(curChar);
                left++;
            }else{
                if(left > 0){
                    realChars.remove(--left);
                }
            }
        }
        String res ="";
        for(int i=0;i<realChars.size();i++){
            res +=realChars.get(i);
        }
        return res;
    }

    public boolean backspaceCompare1(String s, String t) {
        int left = s.length()-1;
        int right = t.length()-1;
        int skipLeft = 0;
        int skipRight = 0;
        while(left >=0 || right >=0){
            while(left >=0){
                if(s.charAt(left) == '#'){
                    skipLeft++;
                    left--;
                }else if(skipLeft>0){
                    skipLeft--;
                    left--;
                }else{
                    break;
                }
            }
            while(right>=0){
                if(t.charAt(right) == '#'){
                    skipRight++;
                    right--;
                }else if(skipRight>0){
                    skipRight--;
                    right--;
                }else{
                    break;
                }
            }
            if(left>=0 && right >=0){
                if(s.charAt(left) != t.charAt(right)){
                    return false;
                }else{
                    left--;
                    right--;
                    continue;
                }
            }
            if(left>=0 || right>=0){
                return false;
            }
        }
        return true;

    }
}
