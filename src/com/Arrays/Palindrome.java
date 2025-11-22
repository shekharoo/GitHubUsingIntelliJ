package com.Arrays;

import java.util.Scanner;

public class Palindrome {

    public static int pali(int input)
    {
        int rev = 0;
        while(input>0)
        {
            rev = rev*10+input%10;
            input=input/10;

        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println("Enter a number: ");//121
        Scanner s = new Scanner(System.in);
        int input1 = s.nextInt();
        System.out.println("Entered no is: "+input1);
        int output = Palindrome.pali(input1);
        System.out.println("Output is: "+output);
        if(input1==output)
        {
            System.out.println("Entered no is Palindrome.");
        }
    }
}
