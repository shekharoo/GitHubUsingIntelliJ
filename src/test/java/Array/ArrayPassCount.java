package Array;

import java.util.Arrays;
import java.util.List;

public class ArrayPassCount {
    public static int sortArray(int[] ar) {
        int count = 0;
        int temp = 0;
        System.out.println("Array length: "+ar.length);
        for (int i = 0; i < ar.length-1; i++) {
            for (int j = 0; j < ar.length-i-1; j++) {
                if (ar[j] > ar[j+1]) {
                    temp = ar[j];
                    ar[j] = ar[j+1];
                    ar[j+1] = temp;
                    count++;
                }
            }
        }
        System.out.println("Sorted array is: "+ Arrays.toString(ar));
        return count;
    }
        public static void main (String[]args){
            int count=ArrayPassCount.sortArray(new int[]{2, 1, 5, 4});
            System.out.println("No of pass is: "+count);
//            List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
//            System.out.println("List is: "+list);
        }
    }
