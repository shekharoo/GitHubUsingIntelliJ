package Array;

import java.util.Arrays;

public class DivideArrayAndTransit {

    public static int[] divideArray(int[] ar)
    {
        int left=0;
        int right=ar.length;
        //int temp = 0;
        while(left<ar.length/2)
        {
            int temp=0;
            ar[temp]=ar[ar.length/2];
            ar[left]=ar[temp];
            left++;
        }
//        while(ar[right]>ar.length/2)
//        {
//            int temp=0;
//            ar[temp]=ar[ar.length/2];
//            ar[right]=ar[temp];
//            right--;
//
//        }
        System.out.println("Array is: "+ Arrays.toString(ar));
        return ar;
    }

    public static void main(String[] args) {
        int[] ar={4,5,8,6,2,4,6,3};
        DivideArrayAndTransit.divideArray(ar);

    }
}
