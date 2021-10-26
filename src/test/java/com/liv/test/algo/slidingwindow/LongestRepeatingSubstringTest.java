package com.liv.test.algo.slidingwindow;

import com.liv.algo.slidingwindow.LongestRepeatSubString;
import org.junit.Assert;
import org.junit.Test;

public class LongestRepeatingSubstringTest {

    private static final LongestRepeatSubString longestRepeatSubStr = new LongestRepeatSubString();

    @Test
    public void test(){
        String aa ="ababcc";
        Assert.assertEquals(2,longestRepeatSubStr.longestRepeatingSubstring(aa));
    }
}
