package DoubleArray;

import org.testng.annotations.Test;

import java.util.Arrays;

public class DoubleArrayClass {

    @Test
    public static void doubleArrayValue()
    {
        String[][] ar ={ {"Shekhar","Anand"},{"Ravi","Anand"}};
        System.out.println("Printing values: "+ Arrays.toString(ar));
        //return new String{ {"Shekhar","Anand"},{"Ravi","Anand"}};
    }
}
