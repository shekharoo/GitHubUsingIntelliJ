package JavaInterviewPgms;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountEachWordAndFrequency {

    public static void countWordFrequency(String s)
    {
        Map<Character,Integer> map=new HashMap<>();
        char[] ch=s.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            map.put(ch[i],map.getOrDefault(ch[i],0)+1);
        }
        System.out.println(map);
        //Set<Map.Entry<Character, Integer>> m = map.entrySet();
        for(Map.Entry<Character,Integer> m:map.entrySet())
        {
            if(m.getValue()==1)  //Only print whose key value=1
            {
                System.out.println(m.getKey()+"==="+m.getValue());
            }

        }

    }

    public static void main(String[] args) {
        CountEachWordAndFrequency.countWordFrequency("Shekhar");
    }
}
