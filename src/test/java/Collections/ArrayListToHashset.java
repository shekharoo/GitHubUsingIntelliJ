package Collections;

import java.util.*;

public class ArrayListToHashset {
    public static void main(String[] args) {
        ArrayList<String> ar=new ArrayList<>();
        ar.add("Shekhar");
        ar.add("Anand");
        ar.add("Shekhar");
        ar.add("Ravi");
        System.out.println(ar);
        Set<String> s= new HashSet<>(ar);
        System.out.println(s);
        ar.add("Rajeev");
        //Iterate using get()
        System.out.println(ar.get(4)); //Rajeev
        //Iterate using iterator()
        System.out.println("using iterator()");
        Iterator<String> itr=ar.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }
        //Iterate using listIterator()
        System.out.println("using list iterator()");
        ListIterator<String> li=ar.listIterator();
        while(li.hasNext())
        {
            System.out.println(li.next());
        }
        //Iterate using for each loop
        System.out.println("using for each loop");
        for(String s1:ar)
        {
            System.out.println(s1);
        }

    }
}
