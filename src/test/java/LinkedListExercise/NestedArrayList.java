package LinkedListExercise;

import java.util.ArrayList;

public class NestedArrayList {

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> ar= new ArrayList<>();
        ArrayList<ArrayList<String>> ar4= new ArrayList<>();

        ArrayList<String> ar1 = new ArrayList<>();
        ar1.add("Shekhar");
        ar1.add("Anand");
        ar1.add("Ravi");
        ArrayList<String> ar2 = new ArrayList<>();
        ar1.add("Rajeev");
        ar1.add("Sanjay");
        ar1.add("Shekhar");
        ArrayList<String> ar3 = new ArrayList<>();
        ar1.add("Gaya");
        ar1.add("bodhgaya");
        ar1.add("Patna");
        ar.add(ar1);
        ar.add(ar2);
        ar4.add(ar3);
        //ar.add(ar4);
        System.out.println("Printing Double Array List: "+ar);
        System.out.println(ar.get(0).get(4).toString());

    }

}
