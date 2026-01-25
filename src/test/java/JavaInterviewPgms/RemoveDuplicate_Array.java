package JavaInterviewPgms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicate_Array {
    public static int removeDuplicate(int[] a)
    {
        int index=0;
        int temp=0;
        for(int i=0;i<a.length-1;i++)
        {
            if(a[i]==a[i+1])
            {
                a[index]=a[i+1];
                index++;
            }
        }
        System.out.println("Array is: "+ Arrays.toString(a));
        return index;
    }
    public static void removeDuplicateUsingHashSet(int[] a)
    {
        Set<Integer> s=new HashSet<>();
        for(int i:a)
        {
            s.add(i);
        }
        System.out.println("After removing duplicate: "+s);
        //Writing back to Integer Array
        int[] ar = new int[s.size()];
        int i=0;
        for(int a1:s)
        {
            ar[i]=a1;
            i++;
        }
        System.out.println("Array is: "+Arrays.toString(ar));
    }
    public static void main(String[] args) {
        int[] ar={1, 1, 2, 2, 3, 3, 6,6,4, 4, 4,};
//        int index = RemoveDuplicate_Array.removeDuplicate(ar);
//        for(int i=0;i<index-1;i++)
//        {
//            System.out.print(ar[i]+",");
//        }
        RemoveDuplicate_Array.removeDuplicateUsingHashSet(ar);

    }
}
