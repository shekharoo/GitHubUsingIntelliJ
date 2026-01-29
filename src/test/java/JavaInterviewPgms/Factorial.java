package JavaInterviewPgms;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Factorial {
    public static int factorialMethod()
    {
        //5->5*4*3*2*1
        System.out.println("Please enter no.");
        int i=0;
        int fact=1;
        Scanner s = new Scanner(System.in);

        int n=s.nextInt();
        for(i=2;i<=n;i++)
        //while(i<=n)
        {
            fact=fact*i;
        }
        System.out.println("Factorial series is: "+fact);
        return fact;

    }

    public static void main(String[] args) {
        Factorial.factorialMethod();
    }

    public static class DuplicateCharacters {
        public static void countDuplicateChars()
        {
            System.out.println("Enter String");
            Map<Character,Integer> map=new HashMap<>();
            Scanner s=new Scanner(System.in);
            String str=s.next();
            char[] ch=str.toCharArray();
            for(int i=0;i<ch.length;i++)
            //for(char c:ch)
            {
                map.put(ch[i],map.getOrDefault(ch[i],0)+1);
            }
            System.out.println(map);
        }
        public static void main(String[] args) {
            DuplicateCharacters.countDuplicateChars();
        }



    }
}
