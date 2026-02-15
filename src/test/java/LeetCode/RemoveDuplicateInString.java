package LeetCode;

public class RemoveDuplicateInString {


    public static StringBuilder removeDuplicate(String s) {
        StringBuilder s1 = new StringBuilder(s);
        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i < s1.length() - 1; i++) {
            if (s1.charAt(i) != s1.charAt(i + 1)) {
                s2.append(s1.charAt(i));
            }
        }
        // Append the last character to ensure it is included
        if (s1.length() > 0) {
            s2.append(s1.charAt(s1.length() - 1));
        }
        System.out.println(s2);
        return s2;
    }
            public static void main(String[] args) {
                RemoveDuplicateInString.removeDuplicate("aabbcccdefgg");
            }
        }
