package com.horstmann.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArraysTest {


    @Test
    public void testArrays() {
        String[] str = new String[]{"a","b","c"};
        List<String> list = Arrays.asList(str);
        List<String> list2 = Arrays.asList("a","b","c");
        List<String> strings = new ArrayList<>(list2);
        List<String> list1 = strings.subList(0, 1);
        list1.clear();
        System.out.println(strings);
    }

    @Test
    public void testUnmodifiableList() {
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("d");
        List<String> unmodifiableList = Collections.unmodifiableList(stringList);
        unmodifiableList.get(0);
        unmodifiableList.clear();//java.lang.UnsupportedOperationException
    }
}
