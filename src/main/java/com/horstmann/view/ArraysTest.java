package com.horstmann.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArraysTest {


    @Test
    public void testArrays() {
        String[] str = new String[]{"a","b","c"};
        List<String> list = Arrays.asList(str);
    }
}
