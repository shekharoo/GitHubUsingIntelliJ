package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//class sortByNameClass implements Comparator<Student_Comparator>
//{
//    public int compare(Student_Comparator o,Student_Comparator o1)
//    {
//        return o.getName().compareTo(o1.getName());
//    }
//}
public class College_Comparator {
    ArrayList<Student_Comparator> stud=new ArrayList<>();
    public void addStudentDetails(String name,int age,String address)
    {

        stud.add(new Student_Comparator(name,age,address));
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
        for(Student_Comparator s:stud)
        {
            System.out.println(s.getName()+"==="+s.getAge()+"==="+s.getAddress());
        }
    }
    public void sort()
    {
        //Collections.sort(Comparator.comparing(Student::getName));
        Collections.sort(stud,new SortByName());
        getStudentDetails();
        //System.out.println(stud);
    }
}
