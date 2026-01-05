package Array;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class ArraysClass {
    @Test
    public void ArraysMethods()
    {
        int[] ar = {5,7,4,2,8,6,1,9,0};
        List<int[]> ar1 = Arrays.asList(ar);
        //System.out.println("Integer array is: "+ar1.toString());
//        for(int i=0;i< ar.length;i++)
//        {
//            System.out.print(ar[i]+" ");
//        }
        Arrays.sort(ar,2,7);
//        for(int i=0;i< ar.length;i++)
//        {
//            System.out.print(ar[i]+" ");
//        }
        Arrays.fill(ar,10);
                for(int i=0;i< ar.length;i++)
        {

            System.out.print(ar[i]+" ");
        }
//        Spliterator.OfInt a = Arrays.spliterator(ar);
//        //System.out.println(a);
//        a.

    }
}
