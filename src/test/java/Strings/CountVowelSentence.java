package Strings;

public class CountVowelSentence {
    public static String vowelCount(String s) {
        String str = "";
        int ep = 0;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != ' ') {
                ep++;
            }
        }
        if (ep > 0) {
            String temp="";
            for (int j = ep; j <=ep; j++) {
                temp=temp+s.charAt(j);
                str=temp+str;
                //str = s.charAt(j)+str;
                //str = str+s.charAt(j);
            }
        }
        System.out.println("Reverse sentence is: "+str);
        String[] splitString = str.split(" ");
        str = splitString[1]+" "+splitString[0];
        return str;
    }



    public static void main(String[] args) {
        String s = "Shekhar Anand"; //Output:rahkehS dnanA
        String s1 = CountVowelSentence.vowelCount(s);
        System.out.println("Reverse Sentence is: "+s1);

    }
}
