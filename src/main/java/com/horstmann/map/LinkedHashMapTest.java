package com.horstmann.map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * LinkedHashMap链接散列映射
 *
 * @author : zhouwei
 * @date : 2019/9/6 10:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LinkedHashMapTest {

    /**
     * LinkedHashMap的访问顺序和插入顺序
     * accessOrder=false,基于插入顺序;
     * accessOrder=true,基于访问顺序
     *
     */
    @Test
    public void iteratorOrder() {
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        Map<String, String> linkedHashMap2 = new LinkedHashMap<>(4, 0.75f, true);
        //HashMap迭代时显示的顺序和插入顺序不一致
        Map<String, String> hashMap = new HashMap<>();

        linkedHashMap.put("a", "Amy");
        linkedHashMap.put("h", "Harry");
        linkedHashMap.put("b", "Bob");
        linkedHashMap.put("l", "Leo");

        linkedHashMap2.put("a", "Amy");
        linkedHashMap2.put("h", "Harry");
        linkedHashMap2.put("b", "Bob");
        linkedHashMap2.put("l", "Leo");

        hashMap.put("a", "Amy");
        hashMap.put("h", "Harry");
        hashMap.put("b", "Bob");
        hashMap.put("l", "Leo");

        //调用get方法对访问顺序进行改变,被调用的元素从当前位置删除并添加到链表尾部
        linkedHashMap2.get("a");
        linkedHashMap2.get("b");

        System.out.println("======>LinkedHashMap按插入顺序迭代key");
        Iterator<String> iterator = linkedHashMap.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("======>LinkedHashMap按插入顺序迭代value");
        Iterator<String> value = linkedHashMap.values().iterator();
        while (value.hasNext()) {
            System.out.println(value.next());
        }
        System.out.println("======>LinkedHashMap按访问顺序迭代");
        linkedHashMap2.forEach((k, v) -> System.out.println(k + "=" + v));
        System.out.println("======>HashMap迭代");
        hashMap.forEach((k, v) -> System.out.println(k + "=" + v));
    }

    /**
     * LinkedHashMap实现LRU'Least Recently Used'最少最近算法
     * 将使用频率较多的数据保存在内存中，使用频率较少的数据查数据库
     * 需要一个LinkedHashMap的子类来覆盖removeEldestEntry方法
     */
    @Test
    public void lru() {
        int size = 4;
        //覆盖removeEldestEntry方法
        Map<String,String> lruMap = new LinkedHashMap<String,String>(size, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<String,String> eldest) {
                if (size() > size) {
                    System.out.println("最近最少使用的是"+eldest.getKey());
                }
                return size() > size;
            }
        };
        //对元素进行添加的时候会先调用removeEldestEntry
        lruMap.put("a", "Amy");
        lruMap.put("h", "Harry");
        lruMap.put("b", "Bob");
        lruMap.put("l", "Leo");
        lruMap.put("c", "Cindy");
        System.out.println(lruMap.toString());//{h=Harry, b=Bob, l=Leo, c=Cindy}
        lruMap.put("m", "Mike");
        lruMap.get("b");
        System.out.println(lruMap.toString());//{l=Leo, c=Cindy, m=Mike, b=Bob}
    }

}
