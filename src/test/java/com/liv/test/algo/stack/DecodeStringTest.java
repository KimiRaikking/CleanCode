package com.liv.test.algo.stack;

import com.liv.algo.stack.DecodeString;
import org.junit.Assert;
import org.junit.Test;

public class DecodeStringTest {

    private DecodeString decodeString = new DecodeString();

    @Test
    public void test(){
        String aa = "3[a]2[bc]";
        Assert.assertEquals("aaabcbc", decodeString.decodeString(aa));
        String bb = "3[a2[c]]";
        Assert.assertEquals("accaccacc", decodeString.decodeString(bb));
    }
}
