package IBM_Array_JavaPgms;

import java.util.Arrays;

public class SecondLargestElementinArray {
    /**[10, 5, 20, 8] → 10
     *
     */
    public static void secondLargest(int[] ar)
    {
        Arrays.sort(ar);
        int arLength=ar.length;
        int largest=ar[arLength-1];
        for(int i=arLength-2;i>=0;i--)
        {
            if(ar[i]!=largest)
            {
                System.out.println("Second Largest is: "+ar[i]);
                break;
                //return ar[i];
            }

        }
    }

//    public static int secondLargest(int[] ar) {
//        int n = ar.length;
//        int largest = ar[n - 1];
//
//        for (int i = n - 2; i >= 0; i--) {
//            if (ar[i] != largest) {
//                return ar[i];
//            }
//        }
//
//        throw new IllegalArgumentException("No second largest element");
//    }

    public static void main(String[] args) {
        SecondLargestElementinArray.secondLargest(new int[]{10, 5, 20, 8});

    }
}
