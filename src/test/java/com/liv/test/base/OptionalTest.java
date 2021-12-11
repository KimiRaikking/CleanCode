package com.liv.test.base;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class OptionalTest {


    @Test
    public void testOptional() {
        FirstLevelObj firstLevelObj = null;
        Assert.assertEquals(true, Optional.ofNullable(firstLevelObj).orElse(null) == null);
        Assert.assertEquals(true, Optional.ofNullable(firstLevelObj).map(FirstLevelObj::getSecLevelObj).map(SecLevelObj::getThirdLevelObj).map(ThirdLevelObj::getValue).orElse("").equals(""));
        firstLevelObj = new FirstLevelObj();
        Assert.assertEquals(true, Optional.of(firstLevelObj).map(FirstLevelObj::getSecLevelObj).orElse(null) == null);
        Assert.assertEquals(true, Optional.of(firstLevelObj).get() != null);
        SecLevelObj secLevelObj = new SecLevelObj();
        firstLevelObj.setSecLevelObj(secLevelObj);
        Assert.assertEquals(true, Optional.of(firstLevelObj).map(FirstLevelObj::getSecLevelObj).get() != null);
        Assert.assertEquals(true, Optional.of(firstLevelObj).map(FirstLevelObj::getSecLevelObj).map(SecLevelObj::getThirdLevelObj).orElse(null) == null);
        ThirdLevelObj thirdLevelObj = new ThirdLevelObj();
        thirdLevelObj.value = "test";
        secLevelObj.setThirdLevelObj(thirdLevelObj);
        Assert.assertEquals("test", Optional.ofNullable(firstLevelObj).map(FirstLevelObj::getSecLevelObj).map(SecLevelObj::getThirdLevelObj).map(ThirdLevelObj::getValue).orElse("test2"));


    }

    public static class FirstLevelObj {
        private SecLevelObj secLevelObj;


        public SecLevelObj getSecLevelObj() {
            return secLevelObj;
        }

        public void setSecLevelObj(SecLevelObj secLevelObj) {
            this.secLevelObj = secLevelObj;
        }
    }

    public static class SecLevelObj {
        private ThirdLevelObj thirdLevelObj;

        public ThirdLevelObj getThirdLevelObj() {
            return thirdLevelObj;
        }

        public void setThirdLevelObj(ThirdLevelObj thirdLevelObj) {
            this.thirdLevelObj = thirdLevelObj;
        }
    }

    public static class ThirdLevelObj {
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
