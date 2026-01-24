package InterviewPractice;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableMainClass {
    public static void main(String[] args) {
        ArrayList<ComparableExample> ar=new ArrayList<>();
        ar.add(new ComparableExample("Shekhar",30,"Domuhan"));
        ar.add(new ComparableExample("Anand",28,"Gaya"));
        ar.add(new ComparableExample("Ravi",25,"Bodhgaya"));
        ar.add(new ComparableExample("Rajeev",35,"AP Colony"));
        ComparableExample c=new ComparableExample(); //Sorted based on age
        Collections.sort(ar);
        for(ComparableExample c1:ar)
        {
            System.out.println("Name is: "+c1.name);
            System.out.println("Age is: "+c1.age);
            System.out.println("Address is: "+c1.address);
            System.out.println("==================");
        }
    }
}
