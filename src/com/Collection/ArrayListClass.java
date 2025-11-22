package com.Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class ArrayListClass {

    public void arrayListOperation()
    {
        ArrayList<String> ar = new ArrayList<>();
        ar.add("Car");
        ar.add("Spresso");
        ar.add("Thar");

    }

    public static void main(String[] args) {
     ArrayList<String> ar = new ArrayList<>();
        ar.add("Shekhar");
        ar.add("Anand");
        ar.add("Ravi");
        //Extract Arraylist using get()
        for(int i=0;i<ar.size();i++)
        {
            System.out.println("printing using get() "+ar.get(i));
        }
        //Sorting Array
        Collections.sort(ar);
        System.out.println("New Sorted List: "+ar);
        //Reverse Array
        Collections.reverse(ar);
        System.out.println("Reversed Array List: "+ar);
        //Iterator<String> ir = ar.iterator();
//        ListIterator<String> li = ar.listIterator();
//        while (li.hasNext())
//        {
//            if(li.next().equalsIgnoreCase("Shekhar"))
//            {
//                //ir.remove();
//                System.out.println("Shekhar is found");
//                li.remove();
//            }
//            //System.out.println("List is: "+ir.next());
//        }
        //System.out.println("List is: "+ir.next());
//        System.out.println("List size is: "+ar.size());
//        for(String s:ar)
//        {
//            System.out.println("List is: "+s);
//        }
//        if(li.next().equals("Shekhar"))
//        {
//            //ir.remove();
//            System.out.println("Anand is found");
//        }
//        System.out.println("List is: "+li.next());
//        System.out.println("List is: "+li.next());
//        System.out.println("List is: "+li.next());
//        Iterator<String> ir = ar.iterator();
//        while (ir.hasNext())
//        {
//            if(ir.next().equalsIgnoreCase("Shekhar"))
//            {
//                //ir.remove();
//                System.out.println("Shekhar is found");
//                ir.remove();
//            }
//            //System.out.println("List is: "+ir.next());
//        }
//        //System.out.println("List is: "+ir.next());
//        System.out.println("List size is: "+ar.size());
//        for(String s:ar)
//        {
//            System.out.println("List is: "+s);
//        }
    }
}
