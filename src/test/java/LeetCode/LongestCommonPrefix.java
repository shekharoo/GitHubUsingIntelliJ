package LeetCode;

import java.util.ArrayList;
import java.util.Collections;

public class LongestCommonPrefix {

    public static void longestCommonPrefix()
    {
        ArrayList<String> arr=new ArrayList<>();
        arr.add("flow");
        arr.add("flight");
        arr.add("flower");
        System.out.println(arr);
        Collections.sort(arr);
        System.out.println(arr);
    }

    public static void main(String[] args) {
        LongestCommonPrefix.longestCommonPrefix();
    }
}
