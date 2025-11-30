package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 5, 20, 9, 30, 50);
        List<Integer> ar= list.stream()
                .filter(x -> x % 2 == 0)
                .filter(x -> x > 10)
                //.forEach(System.out::println);
                .collect(Collectors.toList());
               // .forEach(System.out::println);
        System.out.println("List is: "+ ar);

    }
}
