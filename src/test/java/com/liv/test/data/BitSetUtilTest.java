package com.liv.test.data;

import com.liv.data.BitSetUtil;
import org.junit.Test;

import java.util.BitSet;

public class BitSetUtilTest {

    @Test
    public void testBitSetIndexes(){
        BitSet bitSet = new BitSet(128);
        bitSet.set(128);
        bitSet.set(0);
        System.out.println(BitSetUtil.getAllSets(bitSet));
    }

}
