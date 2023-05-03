package com.liv.test.base.stream;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    public void testBasic1(){
        List<String> words = new ArrayList<>();
        words.add("helen");
        words.add("jack");
        words.add("tom");
        words.add("bob");
        int count1 = (int) words.stream().filter(x -> x.length()>3).count();
        Assert.assertEquals(2, count1);
        int count2 = (int) words.parallelStream().filter(x -> x.length()<5).count();
        Assert.assertEquals(3, count2);

    }

    @Test
    public void testGenerateStream(){
        Stream<String> stringStream = Stream.empty();
        Stream<String> echoStream = Stream.generate(() -> "echo1");
        Assert.assertEquals(0, stringStream.count());
        List<String> echos = echoStream.limit(10).collect(Collectors.toList());
        Assert.assertEquals(10, echos.size());
        Assert.assertEquals("echo1", echos.get(1));
        Stream<Double> randoms = Stream.generate(Math::random);
        List<Double> randomNums = randoms.limit(100).collect(Collectors.toList());
        Assert.assertEquals(100, randomNums.size());
    }

    @Test
    public void testFlatMapStream(){
        List<String> lines = new ArrayList<>();
        lines.add("take a walk");
        lines.add("eat a launch");
        lines.add("go to a sleep");
        Stream<String> lineStream = lines.stream();
        Stream<String> wordStream = lineStream.flatMap(line -> Arrays.asList(line.split(" ")).stream());
        List<String> wordList = wordStream.collect(Collectors.toList());
        Assert.assertEquals(10, wordList.size());
    }
}
