package com.liv.test.base.string;

import org.junit.Assert;
import org.junit.Test;

public class StringMemTest {

    @Test
    public void testMem(){
        String str1 = "hello";
        // heap mem
        String str2 = new String("hello");
        String str3 = "hel"+"lo";
        String str4 = "hel";
        String str5 = "lo";
        String str6 = str4+str5;
        String str7 = "hel" +str5;
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str2 == str3);
        System.out.println(str3 == str6);
        System.out.println(str7 == str6);

        PipelineDoc pipelineDoc1 = new PipelineDoc();
        pipelineDoc1.setPipelineId(str2);

        PipelineDoc pipelineDoc2 = new PipelineDoc();
        pipelineDoc2.setPipelineId(str2);

        System.out.println(pipelineDoc1.getPipelineId() == pipelineDoc2.getPipelineId());
        Assert.assertSame(pipelineDoc1.getPipelineId(),pipelineDoc2.getPipelineId());
    }

    public static class PipelineDoc{
        public String getPipelineId() {
            return pipelineId;
        }

        public void setPipelineId(String pipelineId) {
            this.pipelineId = pipelineId;
        }

        private String pipelineId;
    }
}
