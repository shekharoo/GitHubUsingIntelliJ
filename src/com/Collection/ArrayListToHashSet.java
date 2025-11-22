package com.Collection;

import java.util.*;

public class ArrayListToHashSet {
    public static void main(String[] args) {
        ArrayList<String> ar = new ArrayList<>();
        ar.add("Shekhar");
        ar.add("Ravi");
        ar.add("20");
        ar.add("20");
        ar.add("10");
        ar.add("Anand");
        System.out.println("ArrayList elements: "+ar);
        System.out.println("Arraylist size: "+ar.size());
        //Converting ArrayList to Hashset
        Set<String> set = new HashSet<>(ar);
        //Converting ArrayList to Treeset
        Set<String> set1 = new TreeSet<>(ar);
        System.out.println("Hashset elements: "+set);
        System.out.println("Treeset elements: "+set1);

        //Converting HashSet back to Array:
        Set<String> s = new HashSet<>();
        s.add("Godrej");
        s.add("Hinjewadi");
        s.add("Mastek");
        System.out.println("HashSet elements: "+s);
        Object[] arrayEle = s.toArray();
        System.out.println("Array Elements: "+ Arrays.toString(arrayEle));
        System.out.println("Array element size: "+arrayEle.length);
    }
}
