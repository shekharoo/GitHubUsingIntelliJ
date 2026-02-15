package JavaInterviewPgms;

import java.util.Arrays;

public class RepeatEachCharacterTwice {

    public static void repeatTwice(String str)
    {
        StringBuilder sb=new StringBuilder();
        //String newStr="";
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
           //newStr= newStr+sb.append(str.charAt(i)).toString();
            sb.append(ch).append(ch);
        }
        System.out.println("New String is: "+sb.toString());
    }

    public static void main(String[] args) {
        RepeatEachCharacterTwice.repeatTwice("Kite");
    }

    public static class ReverseCharacterArray {

            public static void reverseArray(char[] ar) {
                //public static void reverseString(String[] ar) {
                char[] ch=new char[ar.length];
                for(int i=ar.length-1;i>=0;i--)
                {
                    //ch[ar.length-i-1]=ar[i];
                    System.out.print(ar[i]+",");
                }
                //System.out.println("Array is: "+ Arrays.toString(ch));

            }

        public static void main(String[] args) {
                //RepeatEachCharacterTwice.repeatTwice("kite");
                ReverseCharacterArray.reverseArray(new char[]{'h', 'e', 'l', 'l', 'o'});
            //String ch = "h","e","l","l","o";
            //ReverseString_Array.reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
            //ReverseString_Array.reverseString(new String[]{"Shekhar"});
    //        char[] ar1=new char[]{'h', 'e', 'l', 'l', 'o'};
    //        String[] str=new String[]{"Shekhar"};
    //        System.out.println(str.toString());
        }
        }
}
