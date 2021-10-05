package com.liv.test.algo.letter;

import com.liv.algo.letter.LetterCombine;
import org.junit.Test;

public class LetterCombinationTest {

    @Test
    public void test(){
        String digits = "23";
        LetterCombine letterCombine = new LetterCombine();
        System.out.println(letterCombine.letterCombinations(digits));
    }

    @Test
    public void test1(){
        String digits = "23";
        LetterCombine letterCombine = new LetterCombine();
        System.out.println(letterCombine.letterCombinations1(digits));
    }
}
