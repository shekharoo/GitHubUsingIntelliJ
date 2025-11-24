package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ArrayListDemo {
    public static String passwordTest(List<String> p)
    {
        List<String> li = new ArrayList<>();
        for(int i=0;i<p.size();i++)
        {
            if(p.get(i)!=" "&&p.get(i).length()>5&& !Pattern.matches("[a-zA-Z]","@Dog15"))
            {
                li.add(p.get(i));
            }
//            System.out.println("Size of all word in list: "+p.get(i).length());
//
        }

        System.out.println("Another list is: "+li);
        return null;
    }

    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("$#@Cat12");
        l.add(" ");
        l.add("@Dog15");
        l.add("abcd");
        l.add("cbfgh");
        l.add("123456");

        //System.out.println("Sorted list: "+l);
        ArrayListDemo.passwordTest(l);
    }
}
