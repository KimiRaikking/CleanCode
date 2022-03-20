package com.liv.base.generic.impl;

import com.liv.base.generic.Processor;

public class NormalProcessor implements Processor {
    @Override
    public void doData(Object o) {
        if(o instanceof String) System.out.println(o);
    }
}
