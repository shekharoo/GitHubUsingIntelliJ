package InterviewPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorExample implements Comparator<Student> {


    public int compare(Student s1,Student s2)
    {
        return (s1.name.compareTo(s2.name));

    }


}
