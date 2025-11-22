package com.Collection;

import java.util.*;

public class SetClass {
    public static void main(String[] args) {
        Set<String> s = new HashSet<String>();
        s.add("Shekhar");
        s.add("Anand");
        s.add("Ravi");
        s.add("Ravi");
        //Iterate through Iterator
        Iterator ir = s.iterator();
        while (ir.hasNext())
        {
            String str = ir.next().toString();
            if (str.equalsIgnoreCase("Shekhar"))
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
