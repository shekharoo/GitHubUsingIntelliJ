package DoubleArray;

import org.testng.annotations.Test;

import java.util.Arrays;

public class DoubleArrayClass {

    @Test
    public static void doubleArrayValue()
    {
        String[][] ar ={ {"Shekhar","Anand"},{"Ravi","Anand"}};
        System.out.println("Printing values: "+ ar);
        //return new String{ {"Shekhar","Anand"},{"Ravi","Anand"}};
        System.out.println("Matrix length is: "+ar.length);
        for(int i=0;i<ar.length;i++)
        {
            for(int j=0;j<ar.length;j++)
            {
                System.out.println(ar[i].length);
                System.out.print(ar[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println("Other method to print 2D Strings: "+Arrays.deepToString(ar));
    }
}
