package com.Arrays;

import java.util.Arrays;

public class BubbleSort {
    static int[] bubbleSort(int[] ar) {
        int temp = 0;
        for (int i = 0; i < ar.length-1; i++) {
            for (int j = 0; j < ar.length-i-1; j++) {
                if (ar[j] > ar[j+1]) {
                    temp = ar[j];
                    ar[j]=ar[j+1];
                    ar[j+1] = temp;
                }
            }
        }
        return ar;
    }
    public static void main(String[] args) {
        int[] ar = {4,1,2,5,3};
        int[] ar1 = BubbleSort.bubbleSort(ar);
        for(int i=0;i<ar1.length;i++)
        {
            System.out.println(ar[i]);
        }
    }
}
