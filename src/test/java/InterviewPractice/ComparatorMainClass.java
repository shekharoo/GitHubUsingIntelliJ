package InterviewPractice;

import java.util.ArrayList;
import java.util.Collections;

public class ComparatorMainClass {
    public static void main(String[] args) {
        ArrayList<Student> ar=new ArrayList<>();
        ar.add(new Student(30,"Shekhar","Domuhan"));
        ar.add(new Student(28,"Anand","Gaya"));
        ar.add(new Student(25,"Ravi","Bodhgaya"));
        ar.add(new Student(35,"Rajeev","AP Colony"));
        Collections.sort(ar,new ComparatorExample1()); //Sorted based on name-->ComparatorExample
        //Sorted based on age-->ComparatorExample1
        for(Student s:ar)
        {
            System.out.println("Name is: "+s.name);
            System.out.println("Age is: "+s.age);
            System.out.println("Address is: "+s.address);
            System.out.println("==================");
        }
    }
}
