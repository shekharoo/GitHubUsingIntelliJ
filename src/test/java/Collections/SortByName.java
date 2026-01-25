package Collections;

import java.util.Comparator;

public class SortByName implements Comparator<Student_Comparator> {
    public int compare(Student_Comparator o,Student_Comparator o1)
    {
        return o.getName().compareTo(o1.getName());
    }
}
