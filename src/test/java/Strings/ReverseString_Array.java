package Strings;

import java.util.Arrays;

public class ReverseString_Array {

        public void reverseString(char[] ar) {
            char[] ch=null;
            for(int i=ar.length;i>0;i--)
            {
                ch[i]=ar[i];
            }
            System.out.println("Array is: "+ Arrays.toString(ch));

        }

    public static void main(String[] args) {
        //String ch = "h","e","l","l","o";
    }
    }
