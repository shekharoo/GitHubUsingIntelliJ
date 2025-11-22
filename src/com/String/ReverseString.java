package com.String;

public class ReverseString {

    public static StringBuilder reverseString(String name)
    {
        StringBuilder nm = new StringBuilder(name);
        String nam = "";
//        for(int i=name.length()-1;i>=0;i--)
//        {
//            nam = nam+name.charAt(i);
//        }
//        for(int i=0;i<name.length();i++)
//        {
//            nam = name.charAt(i)+nam;
//        }
        StringBuilder nam1=nm.reverse();
        return nam1;
    }

    public static void main(String[] args) {
       StringBuilder name = ReverseString.reverseString("Shekhar");
        System.out.println("Reverse String is "+name);
    }
}
