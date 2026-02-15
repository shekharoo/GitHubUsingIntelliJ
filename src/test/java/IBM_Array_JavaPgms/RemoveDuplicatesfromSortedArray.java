package IBM_Array_JavaPgms;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArray {
    /**
     * [1,1,2,2,3,4,4] → [1,2,3,4]
     */

    public static void main(String[] args) {
        /**
         * [1,1,2,2,3,4,4] → [1,2,3,4]
         */
        int[] ar = {1,1,2,2,3,4,4};
        int[] ar1=new int[ar.length];
        int index=0;
        int temp;
        for(int i=0;i<ar.length-1;i++)
        {
            if(ar[i]!=ar[i+1])
            {
                temp=ar[i];
                ar1[index]=temp;
                index++;
            }
        }
        //to compare last no and add it to array manually
        ar1[index]=ar[ar.length-1];
        System.out.println(Arrays.toString(ar1));
    }
}

