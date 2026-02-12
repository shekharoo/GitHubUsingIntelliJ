package StreamPgms;

import java.util.stream.Stream;

public class ReverseString {
    public static void main(String[] args) {
        String s = "My Name is Shekhar Anand";

        String s1 = s.chars().spliterator().toString();
        System.out.println(s1);
        String s2 = ":)";
        System.out.println(s2.length());
        int len=s2.codePointCount(0,10);
        System.out.println(len);
    }
}
