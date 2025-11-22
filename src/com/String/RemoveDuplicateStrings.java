package com.String;

import java.util.Arrays;

public class RemoveDuplicateStrings {

    public static int removeDuplicate(String s)
    {
        char[] ar = s.toCharArray();
        int idx =1;
        //String s1 = "";
        for(int i=1;i<ar.length;i++)//
        {
            if(ar[i]!=ar[idx-1])
            {
                ar[idx++]= ar[i];
            }
        }
        System.out.println("Array is: "+ Arrays.toString(ar));
        System.out.println("Exact array after removing elements: ");
                for(int i=0;i<idx;i++)
        {
            System.out.println(ar[i]);
        }
        String s1 = String.valueOf(ar);
        System.out.println("Required String is: "+ s1.substring(0,idx));
        return idx;
    }

    public static void main(String[] args) {
        String s = "aabbbccccdeee";
        int idx = RemoveDuplicateStrings.removeDuplicate(s);
        //System.out.println("Required String is: "+s5.toString());
//        for(int i=0;i<idx;i++)
//        {
//            System.out.println(s.toCharArray()[i]);
//        }
    }
}
