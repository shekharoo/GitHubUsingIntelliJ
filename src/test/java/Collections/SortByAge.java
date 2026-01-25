package Collections;

public class SortByAge implements Comparable<Student_Comparable>{
    String name;
    int age;
    String address;
    @Override
    public int compareTo(Student_Comparable o) {
        if(this.age==o.getAge())
        {
            return 0;
        }
        else if(this.age>o.getAge())
        {
            return 1;
        }
        else {
            return -1;
        }
    }
}
