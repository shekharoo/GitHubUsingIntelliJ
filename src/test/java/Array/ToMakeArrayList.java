package Array;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ToMakeArrayList {
    @Test
    public void test()
    {
        //List<Integer> li = Arrays.asList(1,6,8,2,9,3,4,5);
        List<String> li1 = Arrays.asList("Shekhar", "Anand", "Ravi", "Anand");
        System.out.println("List is: "+li1);
    }
}
