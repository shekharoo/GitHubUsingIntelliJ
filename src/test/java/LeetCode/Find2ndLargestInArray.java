package LeetCode;

import java.util.Arrays;

public class Find2ndLargestInArray {
    public static void main(String[] args) {
        int[] arr = {10, 45, 20, 8, 45, 30};

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
