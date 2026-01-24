package JavaInterviewPgms;

import java.util.Scanner;

public class PrimeNo {
    public static boolean primeNo()
    {
        System.out.println("Please enter no.");
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        for(int i=2;i<=n/2;i++)
        {
            if(n%i==0)
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        boolean prime=PrimeNo.primeNo();
        if(prime)
        {
            System.out.println("No. is prime no.");
        }
        else
            System.out.println("No. is not prime no.");
    }
}
