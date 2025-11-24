package Strings;

public class ReverseWordOfSentence {

    public static String reverseSentence(String s) {
        String str = "";
        int ep = 0;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != ' ') {
                ep++;
            }
        }
        if (ep > 0) {
            for (int j = 0; j < ep+1; j++) {
                str = s.charAt(j)+str;
            }
        }
        System.out.println("Reverse sentence is: "+str);
        String[] splitString = str.split(" ");
        str = splitString[1]+" "+splitString[0];
        return str;
    }



    public static void main(String[] args) {
        String s = "Shekhar Anand"; //Output:rahkehS dnanA
        String s1 = ReverseWordOfSentence.reverseSentence(s);
        System.out.println("Reverse Sentence is: "+s1);

    }
}
