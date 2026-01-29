package InterviewPractice;

import java.util.*;

public class Practice {
    public static void main(String[] args) {
//        int[] arr = {10, 45, 20, 8, 45, 30,30,45};
//
//        int largest = Integer.MIN_VALUE;
//        int secondLargest = Integer.MIN_VALUE;
//        System.out.println("Largest: "+largest);
//        System.out.println("Second Largest: "+secondLargest);
//
//        for (int num : arr) {
//            if (num > largest) {
//                secondLargest = largest;
//                largest = num;
//            } else if (num > secondLargest && num != largest) {
//                secondLargest = num;
//            }
//        }
//
//        if (secondLargest == Integer.MIN_VALUE) {
//            System.out.println("Second largest not found");
//        } else {
//            System.out.println("Second largest = " + secondLargest);
//        }
        int[] arr = {10, 45, 20, 8, 45, 30,45,30};

        Arrays.sort(arr);

        int largest = arr[arr.length - 1];
        int secondLargest = Integer.MIN_VALUE;

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] != largest) {
                secondLargest = arr[i];
                break;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("Second largest not found");
        } else {
            System.out.println("Second largest = " + secondLargest);
        }
    }
    }
