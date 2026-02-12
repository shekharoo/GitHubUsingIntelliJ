package StreamPgms;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FinfNamesWithA {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Abhijeet", "Shekhar", "Anand", "Kumar").stream().filter(i -> i.startsWith("A")).collect(Collectors.toList());
        Set<String> set = Arrays.asList("Abhijeet", "Shekhar", "Anand", "Kumar").stream().filter(i -> i.startsWith("A")).collect(Collectors.toSet());
       String str = Arrays.asList("Abhijeet", "Shekhar", "Anand", "Kumar").stream().filter(i -> i.startsWith("A")).collect(Collectors.joining());

        System.out.println("List: "+str);
//        long count= Arrays.asList("Abhijeet","Shekhar","Anand","Kumar").stream().filter(i->i.startsWith("A")).count();
//        System.out.println("Count is: "+count);
    }
}
