package com.liv.test.algo.others;

import com.liv.algo.others.RepeatedSubString;
import org.junit.Assert;
import org.junit.Test;

public class RepeatedSubStringTest {

    private RepeatedSubString repeatedSubString = new RepeatedSubString();

    @Test
    public void test(){
        String s = "abcabcabc";
        Assert.assertEquals(true,repeatedSubString.repeatedSubstringPattern(s));
    }
}
