package com.liv.test.algo.sort;

import com.liv.algo.sort.CharFreqSort;
import org.junit.Assert;
import org.junit.Test;

public class CharFreqSortTest {

    private CharFreqSort charFreqSort =  new CharFreqSort();

    @Test
    public void test(){
        String a = "tree";
        Assert.assertEquals("eert",charFreqSort.frequencySort(a));
    }

}
