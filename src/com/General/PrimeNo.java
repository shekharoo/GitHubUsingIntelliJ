package com.General;

import com.Arrays.Palindrome;

import java.util.Scanner;

public class PrimeNo {

    public static void primeNo(int n)
    {
        boolean flag = false;
        if(n%2==0)
        {
            flag = true;
        }
        if(true)
        {
            System.out.println("Given no is Prime no.");
        }

    }
    public static void main(String[] args) {
        System.out.println("Enter a number: ");//121
        Scanner s = new Scanner(System.in);
        int input1 = s.nextInt();
        System.out.println("Entered no is: "+input1);
        //PrimeNo.super
        PrimeNo.primeNo(input1);
    }

}
