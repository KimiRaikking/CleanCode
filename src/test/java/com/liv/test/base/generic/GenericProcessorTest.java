package com.liv.test.base.generic;

import com.liv.base.generic.impl.NormalProcessor;
import com.liv.base.generic.impl.TProcessor;
import org.junit.Test;

public class GenericProcessorTest {

    @Test
    public void test(){
        NormalProcessor processor1 = new NormalProcessor();
        String data1 = "normal process";
        processor1.doData(data1);
        TProcessor tProcessor = new TProcessor();
        int data2 = 12;
        tProcessor.doData(data2);
    }
}
