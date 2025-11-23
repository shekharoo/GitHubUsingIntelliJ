package LinkedListExercise;

import java.util.LinkedList;

public class LinkedListClass {
    public static void calculateSum()
    {
        LinkedList<String> ll = new LinkedList<>();
        ll.add("Shekhar");
        ll.add("Ravi");
        ll.add("Anand");
        System.out.println("Linked list element: "+ll);
        System.out.println(ll.pop());
        System.out.println("Linked list element: "+ll);
        ll.removeLast();
        System.out.println("Linked list element: "+ll);
    }

    public static void main(String[] args) {
        LinkedListClass.calculateSum();

    }
}
