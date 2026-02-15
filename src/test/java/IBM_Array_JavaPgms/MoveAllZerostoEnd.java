package IBM_Array_JavaPgms;

import java.util.Arrays;

public class MoveAllZerostoEnd {
    /**
     * [0,1,0,3,12] → [1,3,12,0,0]
     */
    public static void main(String[] args) {
        int[] ar = {0, 1, 0, 3, 12};
        int nonZeroIndex=0;
        for(int i=0;i<ar.length;i++)
        {
            if(ar[i]!=0)
            {
                ar[nonZeroIndex]=ar[i];
                nonZeroIndex++;
            }
        }
        System.out.println(Arrays.toString(ar));
        System.out.println("Value of nonZeroIndex: "+nonZeroIndex);

        //Fill remaining values with zero
        for(int i=nonZeroIndex;i<ar.length;i++)
        {
            ar[i]=0;
        }
        System.out.println(Arrays.toString(ar));
    }
}
