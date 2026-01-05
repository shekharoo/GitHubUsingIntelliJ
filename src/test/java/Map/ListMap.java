package Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListMap {
    public static void main(String[] args) {
        List<Map<String,String>> map = new ArrayList<>();
        Map<String,String> m=new HashMap<>();
        m.put("Shekhar","Anand");
        m.put("Ravi","Anand");
        map.add(m);
        System.out.println("List is: "+map);


    }
}
