package com.Arrays;

import javax.imageio.stream.ImageInputStream;
import java.util.Arrays;

public class RemoveDuplicate {

       static int removeDuplicates(int[] ar) {
           int idx =1;
           //int[] ar1=new int[20];
           for(int i=1;i<ar.length;i++)// 0
           {
                   if(ar[i]!=ar[idx-1])
                   {
                       ar[idx++]= ar[i];
                   }
           }
           System.out.println("New array is: "+ Arrays.toString(ar));

           return idx;
       }

    public static void main(String[] args) {
           //int[] ar = {1,1,1,2,2,3,3,3};
           int[] ar = {4,4,4,5,5,6,6,6};
        int k = RemoveDuplicate.removeDuplicates(ar);
        System.out.println("After removing duplicate elements:");
        for(int i=0;i<k;i++)
        {
            System.out.println(ar[i]);
        }
//        int n = 152;
//        System.out.println(n%10);
//        System.out.println(n/10);

    }
}
