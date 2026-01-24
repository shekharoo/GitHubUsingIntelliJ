package JavaInterviewPgms;

import java.util.Scanner;

public class EvenNo {
    public static int evenNo()
    {
        System.out.println("Please enter no.");
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        if(n%2==0)
        {
            System.out.println("Given no. "+n+" is even no");
        }
        else
            System.out.println("Given no. "+n+" is not even no");
        return n;
    }
    public static void main(String[] args) {
        EvenNo.evenNo();
    }
}
