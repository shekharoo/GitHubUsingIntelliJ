package JavaInterviewPgms;

import java.util.Arrays;
import java.util.Collections;

public class ReverseArray {

    public static void reverseArray(char[] ch)
    {
        char[] chReverse=new char[ch.length];
        for(int i=0;i<ch.length;i++)
        {
            chReverse[i]=ch[ch.length-1-i];
        }
        System.out.println("Array is: "+ Arrays.toString(chReverse));
    }

    public static void main(String[] args) {
        ReverseArray.reverseArray(new char[]{'h','e','l','l','o'});
    }
}
