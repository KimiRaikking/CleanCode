package com.liv.test.algo.unionfind;

import com.liv.algo.unionfind.EquationCal;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EquationCalTest {

    @Test
    public void test1(){
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList(new String[]{"x1","x2"}));
        equations.add(Arrays.asList(new String[]{"x2","x3"}));
        equations.add(Arrays.asList(new String[]{"x1","x4"}));
        equations.add(Arrays.asList(new String[]{"x2","x5"}));
        double[] values = {3.0,0.5,3.4,5.6};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList(new String[]{"x2","x4"}));
        EquationCal equationCal = new EquationCal();
        equationCal.calcEquation(equations,values,queries);
    }
}
