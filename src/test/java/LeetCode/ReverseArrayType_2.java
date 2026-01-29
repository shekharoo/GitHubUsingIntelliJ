package LeetCode;

import java.util.Arrays;

public class ReverseArrayType_2 {
    public static void main(String[] args) {
        int[] ar = {10,60,30,80,50,90,20};  // {50,90,20,80,10,60,30}
        int length=ar.length-1;
        int left=0;
        int right=length;
        int temp=0;
        int mid=ar.length/2;
        int[] ar1 = new int[ar.length];
        //System.out.println(right);
        for(int i=0;i<mid;i++)
        {
            ar1[i]=ar[mid+1+i];
        }
        ar1[mid]=ar[mid];
        for(int i=0;i<mid;i++)
        {
            ar1[mid+1+i]=ar[i];
        }
        System.out.println(Arrays.toString(ar1));

    }
    }

