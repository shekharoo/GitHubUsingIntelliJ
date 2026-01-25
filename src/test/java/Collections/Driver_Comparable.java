package Collections;

public class Driver_Comparable {
    public static void main(String[] args) {
        College_Comperable c = new College_Comperable();
        c.addStudentDetails("Shekhar",25,"Domuhan");
        c.addStudentDetails("Rajeev",35,"AP Colony");
        c.addStudentDetails("Ravi",25,"Gaya");
        System.out.println("===Before Sorting===");
        c.getStudentDetails();
        System.out.println("===After Sorting===");
        c.sort();

    }
}
