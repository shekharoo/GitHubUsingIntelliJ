package JavaInterviewPgms;

import java.util.Scanner;

public class ReverseSentence {
    public static String reverseUsingTraditionalWay(String s)
    {
        String[] sSplit = s.split(" ");
        System.out.println("Split size: "+sSplit.length);
        //System.out.println(sSplit[4]);
        String rev="";
        for(int i=0;i<sSplit.length;i++)
        {
            for(int j=sSplit[i].length()-1;j>=0;j--)
            {
                rev=rev+sSplit[i].charAt(j);
            }
            rev=rev+" ";

        }
        //System.out.println("Rev sentence is: "+rev);
        return s;
    }

    public static String reverseSentenceStringBuilder(String st)
    {
       // System.out.println("Please enter a sentence");
//        Scanner s = new Scanner(System.in);
//        String st=s.next();
        int count=0;
        String s1;
        String revString="";
        String[] str = st.split(" ");
        System.out.println("Length of Sentence: "+str.length);
//        System.out.println(str[0]);
//        System.out.println(str[1]);
//        System.out.println(str[2]);
//        System.out.println(str[3]);
//        System.out.println(str[4]);
        //System.out.println(str[5]);

        for(int i=0;i< str.length;i++)
        {
            char ch=' ';
            StringBuilder sb= new StringBuilder(str[i]);
            revString=revString+sb.reverse().toString()+" ";
//            s1=str[i];
//            count++;
            System.out.println("Length of Sentence: "+str[i]);
        }
        System.out.println("Reverse String is: "+revString);
        return st;
    }

    public static void main(String[] args) {
        ReverseSentence.reverseSentenceStringBuilder("Java is good programming languages");
    }
}
