package com.liv.data;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class BitSetUtil {


    public static List<Integer> getAllSets(BitSet bitSet){
        List<Integer> indexes = new ArrayList<>();
        int index = bitSet.nextSetBit(0);
        while (index!= -1){
            indexes.add(index);
            index = bitSet.nextSetBit(index+1);
        }
        return indexes;
    }
}
