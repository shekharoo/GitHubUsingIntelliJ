package Collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Set;

public class SetClass {
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();
        s.add("Shekhar");
        s.add("Anand");
        s.add("Ravi");
        //System.out.println(s);
        Object[] ch = s.toArray();
        //System.out.println(Arrays.toString(ch));
        int[] i = {4,5,1,7,2,0,9};
        Set<String> s1 = new HashSet<>(i.length);
        System.out.println(s1);
    }
}
