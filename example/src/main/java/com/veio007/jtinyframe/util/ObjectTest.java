package com.veio007.jtinyframe.util;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.el.util.ReflectionUtil;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class ObjectTest{
    private String str;
    private Long lg;
    public ObjectTest(String s, Long l) {
        this.str = s;
        this.lg = l;
    }

    @Override
    public String toString() {
        return "ObjectTest{" +
                "str='" + str + '\'' +
                ", lg=" + lg +
                '}';
    }

    public static void main(String[] args) {
        ObjectTest t1 = new ObjectTest("11",10L);
        ObjectTest t2 = new ObjectTest("09",10L);
        ObjectTest t3 = new ObjectTest("12",10L);
        Set<ObjectTest> set = new TreeSet<>(new Comparator<ObjectTest>() {
            @Override
            public int compare(ObjectTest o1, ObjectTest o2) {
                return o1.str.compareTo(o2.str);
            }
        });

        set.add(t3);
        set.add(t2);
        set.add(t1);

        for( ObjectTest o : set) {
            System.out.println(o);
        }
    }
}
