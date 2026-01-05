package Array;

import java.util.Arrays;

public class SortAnArray {
    public static void main(String[] args) {
        int[] ar = {5,1,3,7,4,5,9};
        int lc=0;
        int rc=0;
        int temp=0;
        for(int i=0;i<ar.length-1;i++)
        {
            for(int j=0;j<ar.length-i-1;j++)
            {
                if(ar[j]>=ar[j+1])
                {
                    temp=ar[j];
                    ar[j]=ar[j+1];
                    ar[j+1]=temp;
                    lc++;

                }
            }
        }

        System.out.println("Sorted Array is: "+ Arrays.toString(ar));
    }
}
