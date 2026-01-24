package JavaInterviewPgms;

import java.util.Scanner;

public class NoOfWordsInSentence {

    public static String reverseSentence(String st)
    {
//        System.out.println("Please enter a sentence");
//        Scanner s = new Scanner(System.in);
//        String str=s.nextLine();
        int count=1;
        for(int i=0;i< st.length()-1;i++)
        {
            if ((st.charAt(i) == ' ') && (st.charAt(i + 1) != ' '))
                count++;
        }
        System.out.println("Count is: "+count);
        return st;
    }

    public static void main(String[] args) {
        NoOfWordsInSentence.reverseSentence("Java is good programming languages in future!!");
    }
}
