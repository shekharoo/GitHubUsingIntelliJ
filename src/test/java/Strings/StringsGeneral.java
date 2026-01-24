package Strings;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class StringsGeneral {
//    StringsGeneral(int i)
//    {
//        System.out.println(i);
//    }
    public void countChar(String s)
    {
        Map<Character,Integer> m=new HashMap<>();
        for(char ch:s.toCharArray())
        {
            m.put(ch, m.getOrDefault(ch,0)+1);
        }
        System.out.println(m.entrySet());
        for(Map.Entry<Character,Integer> m1:m.entrySet())
        {
            System.out.println(m1.getKey()+"===="+m1.getValue());
        }
    }

    public static void main(String[] args) {
        StringsGeneral g = new StringsGeneral();
        //g.countChar("Shekhar");
        String s="Shekhar";
        Set<String> set=new HashSet<>(Collections.singleton(s));
        System.out.println(set);
//        //StringsGeneral g1 = new StringsGeneral(10);
//        StringsGeneral g1=g;
//        System.out.println(g==g1);
//        System.out.println(g.equals(g1));
//        char[] ch={'a','e','i'};
//        String s=new String(ch);
//        System.out.println("String is: "+s);
//        String str="hello";
//        String str1="hello";
//        System.out.println(str==str1);
//        System.out.println(str.equals(str1));

//        System.out.println(s);
//        System.out.println("==============");
//        String s1 = s.trim();
//        System.out.println(s1);
//          String s="Shekhar";
//          String s1="Shekhar";
//        System.out.println((s.compareTo(s1)));
//        Map<Integer,String> m = new HashMap<>();
//        //m.getOrDefault()
//        m.put(1,"Shekhar");
//        //m.put("Ravi","Anand");
//        Set<Map.Entry<Integer, String>> e = m.entrySet();
//        System.out.println(e);
//        for(Map.Entry<Integer, String> m1:e)
//        {
//            int s = m1.getKey();
//            System.out.println("key is: "+s);
//        }

    }
}
