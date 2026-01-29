package LeetCode;

import java.util.Arrays;

public class ReverseArrayType_1 {
    public static void main(String[] args) {
        int[] ar = {10,60,30,80,50,90,20};  // {20,90,50,80,30,60,10}
        int length=ar.length-1;
        int left=0;
        int right=length;
        int temp=0;
        int mid=ar.length/2;
        System.out.println(right);
        while(left<right)
        {
            temp=ar[left];
            ar[left]=ar[right];
            ar[right]=temp;
            left++;
            right--;
        }
        //left++;
        //right--;
        System.out.println(Arrays.toString(ar));

    }
    }

