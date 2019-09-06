package com.horstmann.map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.EnumMap;
import java.util.EnumSet;

/**
 * EnumSet/Map  枚举集和映射
 *
 * @author : zhouwei
 * @date : 2019/9/6 10:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EnumMapTest {

    @Test
    public void constructor() {
        EnumSet<Phone> all = EnumSet.allOf(Phone.class);
        EnumSet<Phone> noneOf = EnumSet.noneOf(Phone.class);
        EnumSet<Phone> range = EnumSet.range(Phone.Huawei, Phone.Xiaomi);
        EnumSet<Phone> of = EnumSet.of(Phone.Huawei, Phone.Xiaomi);
        System.out.println("EnumSet.allOf(Phone.class)==" + all);
        System.out.println("EnumSet.noneOf(Phone.class)==" + noneOf);
        System.out.println("EnumSet.range(Phone.Huawei, Phone.Xiaomi)==" + range);
        System.out.println("EnumSet.of(Phone.Huawei, Phone.Xiaomi)" + of);

    }
    enum Phone {
        Apple,
        Huawei,
        Sumsung,
        Xiaomi
    }

    @Test
    public void constructor2() {
        EnumMap<Phone, String> enumMap = new EnumMap<>(Phone.class);
    }
}
