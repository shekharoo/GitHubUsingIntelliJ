package IBM_String_JavaPgms;

import java.util.regex.Pattern;

public class SubStringAndAppendPractice {
    public static void main(String[] args) {
        //String s="abc@gmail.com";
//         String res=s.substring(3);
//        String res1 = s.substring(0, 3);
//        System.out.println(res);
//        System.out.println(res1);
        //int index = s.indexOf("@");
        //Masked
//        String s="9987452014";
//        //System.out.println("@ Index is: "+index);
//        StringBuilder sb=new StringBuilder();
//        int unmasked=4;
//        int masked=s.length()-unmasked;
//        for(int i=0;i<masked;i++)
//        {
//            sb.append("*");
//        }
//        sb.append(s.substring(masked));
//        System.out.println("Masked substring is: "+sb);
        //Date validation:
//        String date="13.10/1990";
//        String regex="\\d{2}.\\d{2}/\\d{4}";
//        boolean flag = Pattern.matches(regex, date);
//        System.out.println("Date matches: "+flag);
        String str = "ABC";
        int j=0;
        String subStr=str.substring(1);
        System.out.println(subStr);
        for (int i = 0; i < str.length(); i++) {

            // Pick character
            char current = str.charAt(i);
            System.out.println("Current char: "+current);

            // Remaining string
            String remaining = str.substring(0, i) + str.substring(i + 1);
            System.out.println("Remaining: in iteration: "+i+" "+ remaining);

        }
    }
}
