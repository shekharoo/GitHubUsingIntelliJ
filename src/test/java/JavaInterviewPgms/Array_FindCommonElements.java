package JavaInterviewPgms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Array_FindCommonElements {
    public static int findCommonElement(int[] a,int[] b)
    {
        Set<Integer> s = new HashSet<>();
        Set<Integer> commonSet = new HashSet<>();
        for(int i:a)
        {
            s.add(i);
        }
        System.out.println("1st HashSet: "+s);
        for(int i:b)
        {
            if(s.contains(i))
            {
                commonSet.add(i);
            }
        }
        System.out.println("Commom elements are: "+commonSet);
        return 5;
    }
    public static void main(String[] args) {
        //Array_FindCommonElements.findCommonElement(new int[]{4, 8, 9, 2, 7, 3}, new int[]{1,6,4,7,9,3});
        ArrayList<String> a = new ArrayList<>();
        a.add("Shekhar");
        a.add("Ravi");
        a.add("Anand");
        a.add("Rajeev");
        Collections.sort(a);
        //After sorting in asc
        System.out.println("In ascending order");
        System.out.println(a);
        //in descending
        System.out.println("In descending order");
        Collections.reverse(a);
        System.out.println(a);
    }
}
