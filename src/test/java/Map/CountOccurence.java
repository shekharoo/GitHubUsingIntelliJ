package Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CountOccurence {
    public static void countCharacter(String s)
    {
        Map<Character,Integer> map = new HashMap<>();
        for(char ch:s.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        System.out.println("Map display: "+map);
        //Display character occurences:
        for(Map.Entry<Character,Integer> entry:map.entrySet())
        {
            System.out.println(entry.getKey() +":"+entry.getValue());
        }
        System.out.println("Map display: "+map);
    }

    public static void main(String[] args) {
        System.out.println("Enter a String");
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        CountOccurence.countCharacter(s1);
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
//        String s = "Success";
//        Map<Character,Integer> map= new HashMap<>();
//        for(int i=0;i<s.length();i++)
//        {
//            map.put(s.charAt(i),i);
//        }
//        map.put("Shekhar",101);
//        map.put("Anand",2);
//        map.put("Bazaar",3);
//        System.out.println(map);
//        Set<Map.Entry<String, Integer>> set = map.entrySet();
//        System.out.println("Entry Set: "+set);
//        Integer value = map.getOrDefault("Shekhar", 0);
//        System.out.println("Value is: "+value);
//        System.out.println("Map is: "+map);


    }
}

