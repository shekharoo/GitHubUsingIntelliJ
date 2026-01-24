package JavaInterviewPgms;

import java.util.Scanner;

public class SumOfDigits {
    public static int sumOfDigits()
    {
        //5->5*4*3*2*1
        System.out.println("Please enter no.");
        int sum=0;
        //int fact=1;
        int i=0;
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        while(n>0)
        {
            sum=sum+n%10;
            n=n/10;
        }
        System.out.println("sum of digits is: "+sum);
        //System.out.println("No of digits: "+i);
        return sum;

    }

    public static void main(String[] args) {
          SumOfDigits.sumOfDigits();
//        int n=2;
//        int m=n%10;
//        System.out.println(m);
    }
}
