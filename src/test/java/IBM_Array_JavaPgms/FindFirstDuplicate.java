package IBM_Array_JavaPgms;

import java.util.HashSet;
import java.util.Set;

public class FindFirstDuplicate {
    /**
     * Input:  {2, 1, 3, 5, 3, 2}
     * Output: 3
     */
    //1st approach using Hashset and return first occurence
    public static int fisrtDuplicate(int[] ar)
    {
        Set<Integer> s=new HashSet<>();
        for(int i:ar)
        {
            if(s.contains(i))
            {
                return i;
            }
            s.add(i);
        }
        return -1;

    }

    //2nd approach using normal for loop
    public static int findDuplicateUsingArray(int[] ar)
    {
        for(int i=0;i<ar.length-1;i++)
        {
            for(int j=i+1;j<ar.length-1;j++)
            {
                if(ar[i]==ar[j])
                {
                    return ar[i];
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
//       int duplicate= FindFirstDuplicate.fisrtDuplicate(new int[]{2, 1, 3, 5, 3, 2});
//        System.out.println("Duplicate is: "+duplicate);
        int duplicate= FindFirstDuplicate.findDuplicateUsingArray(new int[]{2, 1, 3, 5, 3, 2});
        System.out.println("Duplicate is: "+duplicate);
    }


}
