package Collections;

import java.util.ArrayList;
import java.util.Collections;

public class College_Comperable {
    ArrayList<Student_Comparable> stud=new ArrayList<>();
    public void addStudentDetails(String name,int age,String address)
    {

        stud.add(new Student_Comparable(name,age,address));
    }
//    public void addStudentDetailsList(String name,int age,String address)
//    {
//
//        ArrayList<Student> ar = new ArrayList<>();
//        ar.add
//    }
    public void getStudentDetails()
    {
//        for(int i=0;i<stud.size();i++)
//        {
//            System.out.println(stud.get(i).getName()+"==="+stud.get(i).getAge()+"==="+stud.get(i).getAddress());
//        }
        for(Student_Comparable s:stud)
        {
            System.out.println(s.getName()+"==="+s.getAge()+"==="+s.getAddress());
        }
    }
    public void sort()
    {
        //Collections.sort(Comparator.comparing(Student::getName));
        Collections.sort(stud);
        getStudentDetails();
        //System.out.println(stud);
    }
}
