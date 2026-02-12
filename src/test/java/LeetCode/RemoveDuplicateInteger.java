package LeetCode;

import java.util.Arrays;

public class RemoveDuplicateInteger {
    public static int[] removeDuplicate(int[] ar)
    {
        int[] ar1=new int[ar.length];
        int idx=0;
        for(int i=0;i<ar.length-1;i++)
        {
            if(ar[i]!=ar[i+1])
            {
                ar1[idx]=ar[i];
                idx++;
            }
        }
        System.out.println("Array without duplicate: "+ Arrays.toString(ar1));
        return ar1;
    }

    public static void main(String[] args) {
        RemoveDuplicateInteger.removeDuplicate(new int[]{1,1,2,2,2,3,4,5,5,6});
    }
}
