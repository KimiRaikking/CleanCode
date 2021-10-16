package com.liv.test.algo.dp;

import com.liv.algo.dp.EncodeCountCal;
import org.junit.Assert;
import org.junit.Test;

public class EncodeCountCalTest {

    private static final EncodeCountCal encodeCountCal = new EncodeCountCal();

    @Test
    public void test(){
        Assert.assertEquals(encodeCountCal.numDecodings("12"),2);
        Assert.assertEquals(encodeCountCal.numDecodings("226"),3);
        Assert.assertEquals(encodeCountCal.numDecodings("06"),0);
    }
}
