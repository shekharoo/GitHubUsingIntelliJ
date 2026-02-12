package JavaInterviewPgms;

import java.util.stream.Collectors;

public class RemoveDuplicatesInString {
    public static void main(String[] args) {
        String s="aabbbcccdefg";
        //s.toCharArray().
        //StringBuilder sb=new StringBuilder("aabbbcccdefg");
        String s1 = s.chars().distinct().mapToObj(c -> String.valueOf((char)c)).collect(Collectors.joining());
        System.out.println(s1);

    }
}
