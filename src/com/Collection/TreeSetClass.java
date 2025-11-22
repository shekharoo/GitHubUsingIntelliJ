package com.Collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetClass {
    public static void main(String[] args) {
        TreeSet<String> s = new TreeSet<>();
        s.add("10");
        s.add("Shekhar");
        s.add("Anand");
        s.add("Ravi");
        s.add("Ravi");
        s.add("20");
        System.out.println("Tree set elements: "+s);
        //Descending Iterator:
        System.out.println("Printing descending iterator elements: ");
        Iterator ir1 = s.descendingIterator();
        while(ir1.hasNext())
        {
            System.out.println(ir1.next());
        }
        //Iterate through Iterator
        Iterator ir = s.iterator();
        while (ir.hasNext())
        {
            String str = ir.next().toString();
            if (str.equalsIgnoreCase("Anand"))
            {
                ir.remove();
                System.out.println("Remove element: "+ str +" is successful!!");
            }

        }

        for (String s1:s)
        {
            System.out.println(s1);
        }
        System.out.println("Set Output: "+s);

    }
}
