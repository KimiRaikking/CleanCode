package com.liv.base.generic.impl;

import com.liv.base.generic.Processor;

public class TProcessor implements Processor<Integer> {
    @Override
    public void doData(Integer data) {
        System.out.println("num is "+ data);
    }
}
