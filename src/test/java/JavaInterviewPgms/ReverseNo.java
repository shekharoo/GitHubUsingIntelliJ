package JavaInterviewPgms;

import java.util.Scanner;

public class ReverseNo {
    public static int reverseNo()
    {
        //5->5*4*3*2*1
        System.out.println("Please enter no.");
        int rev=0;
        //int fact=1;
        int i=0;
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        while(n>0)
        {
            rev=rev*10+n%10;
            n=n/10;
            i++;
        }
        System.out.println("rev no is: "+rev);
        System.out.println("No of digits: "+i);
        return rev;

    }

    public static void main(String[] args) {
          ReverseNo.reverseNo();
//        int n=2;
//        int m=n%10;
//        System.out.println(m);
    }
}
