package Array;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static int[] removeSortDuplicate(int[] a) {
      int index=1; //index=1 because, we will keep next no next to 0 or 1st index.
        for(int i=1;i<a.length;i++)
        {
            if(a[i]!=a[i-1])// always compare with prev element in the array
            {
                a[index]=a[i];
                index++;// move index only when our condition is satisfied, because index is next element position, if it is
                //moved always then it will be like, 0,1,1,2,2,but we
                // want like 0,1,2,3   like this, so index increase only when our condition is
                //satisfied.
            }
        }
                System.out.println("Array is: " + Arrays.toString(a));
                System.out.println("Count is: " + index);
                return a;
            }

    public static void main(String[] args) {
       int[] ar= RemoveDuplicatesFromSortedArray.removeSortDuplicate(new int[]{0,0,1,1,1,2,2,3,3,4});
        System.out.println("New sorted array is: "+ Arrays.toString(ar));
    }
}
