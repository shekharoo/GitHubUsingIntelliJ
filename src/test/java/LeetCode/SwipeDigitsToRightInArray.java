package LeetCode;

import java.util.Arrays;

public class SwipeDigitsToRightInArray {
    public static void main(String[] args) {
        int[] ar={10,0,0,10,20};
        int right=0;
        int left=0;
        int temp=0;
        for(int i=0;i<ar.length;i++)
        {
            if(ar[i]!=0)
            {
                temp=ar[left];
                ar[left]=ar[right];
                ar[right]=temp;
                left++;
            }
            right++;
        }
        System.out.println("Array is: "+ Arrays.toString(ar));
    }
}

/***
 * Logic behind this:
 * 🎯 Goal
 *
 * Move all 0s to the end, keep the order of non-zero elements.
 *
 * Input
 * [10, 0, 0, 10, 20]
 *
 * 🧭 Pointer Meaning
 *
 * R (right) 👉 scans elements
 *
 * L (left) 👉 position to place next non-zero
 *
 * ▶️ Animation Walkthrough
 * 🔹 Step 1
 * L
 * R
 * [10, 0, 0, 10, 20]
 *
 *
 * arr[R] = 10 (non-zero)
 *
 * Swap arr[L] ↔ arr[R] (same index)
 *
 * Move L
 *
 *    L
 *       R
 * [10, 0, 0, 10, 20]
 *
 * 🔹 Step 2
 *    L
 *       R
 * [10, 0, 0, 10, 20]
 *
 *
 * arr[R] = 0
 *
 * Do nothing, just move R
 *
 *    L
 *          R
 * [10, 0, 0, 10, 20]
 *
 * 🔹 Step 3
 *    L
 *          R
 * [10, 0, 0, 10, 20]
 *
 *
 * arr[R] = 0
 *
 * Still nothing, move R
 *
 *    L
 *             R
 * [10, 0, 0, 10, 20]
 *
 * 🔹 Step 4
 *    L
 *             R
 * [10, 0, 0, 10, 20]
 *
 *
 * arr[R] = 10 (non-zero)
 *
 * Swap arr[L] and arr[R]
 *
 *       L
 *                R
 * [10, 10, 0, 0, 20]
 *
 * 🔹 Step 5
 *       L
 *                R
 * [10, 10, 0, 0, 20]
 *
 *
 * arr[R] = 20 (non-zero)
 *
 * Swap arr[L] and arr[R]
 *
 *          L
 *                   R
 * [10, 10, 20, 0, 0]
 *
 * ✅ Final Output
 * [10, 10, 20, 0, 0]
 *
 * 🧠 How to say this in an interview
 *
 * “The right pointer scans the array.
 * Whenever it finds a non-zero, it swaps it into the left pointer position.
 * This keeps the order intact and pushes zeros to the end automatically.”
 *
 */
