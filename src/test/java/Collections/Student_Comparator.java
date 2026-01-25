package Collections;

//public class Student_Comparator extends College_Comperable implements Comparable<Student_Comparator>{
public class Student_Comparator{

   Student_Comparator()
   {

   }
    private String name;
    private int age;
    private String address;
    Student_Comparator(String name, int age, String address)
    {
        super();
        this.name=name;
        this.age=age;
        this.address=address;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
//    @Override
//    //To sort int attribute
//    public int compareTo(Student o) {
//        if(this.age==o.getAge())
//        {
//            return 0;
//        }
//        else if(this.age>o.getAge())
//        {
//            return 1;
//        }
//        else {
//            return -1;
//        }
//        //return Integer.compare(this.id, other.id);
//    }

    //To sort String attribute
//       public int compareTo(Student_Comparator o) {
//            return this.address.compareTo(o.getAddress());
//       }

//    public static void main(String[] args) {
//        Student s = new Student();
//        List<Student> ar=new ArrayList<Student>();
//        s.addStudentDetails("Shekhar",35,"Domuhan");
//        s.addStudentDetails("Ravi",25,"Gaya");
//        ar.add("Shekhar",35,"Domuahn");
//        ar.add("Ravi",25,"Gaya");
//        s.getStudentDetails();
//        System.out.println("======Sorting=======");
//        Collections.sort(ar);
//        s.getStudentDetails();
//        //System.out.println(ar);
//
//    }


}
