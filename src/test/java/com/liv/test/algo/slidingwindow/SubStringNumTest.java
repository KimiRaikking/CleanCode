package com.liv.test.algo.slidingwindow;

import com.liv.algo.slidingwindow.SubStringNums;
import org.junit.Test;

public class SubStringNumTest {

    private SubStringNums subStringNums = new SubStringNums();

    @Test
    public void test(){
        String s = "aabb";
        String key = "ab";
        System.out.println(subStringNums.calNums(s,key));
    }
}
