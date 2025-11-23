package Map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EntrySet {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("Shekhar",1);
        map.put("Anand",2);
        map.put("Ravi",3);
        //Map.Entry<String,Integer> enrty = map.entrySet<String,Integer>;
        Set<String> s = new HashSet<>();
        s.add("Shekhar");
        s.add("Anand");
        s.add("Shekhar");
        System.out.println(s);
    }
}
