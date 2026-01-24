package JavaInterviewPgms;

import java.util.Scanner;

public class Fibonacci {
    public static int fibonacciMethod()
    {
        //0,1,1,2,3,5,8,13
        System.out.println("Please enter no.");
        int i=0;
        int first=0;
        int second=1;
        int next=0;
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        for(i=0;i<=n;i++)
        //while(i<=n)
        {
            System.out.print(first+" ");
            next=first+second;
            first=second;
            second=next;
        }
        System.out.println("Fibonacci series is: "+next);
        return next;

    }

    public static void main(String[] args) {
        Fibonacci.fibonacciMethod();
    }
}
