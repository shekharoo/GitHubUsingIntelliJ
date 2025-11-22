package com.com;

import java.util.ArrayList;

public class ComparatorSubClass{

        public void comparatorClass2(){
        ArrayList<String> ar = new ArrayList<>();
        ar.add("pen");
        ar.add("train");
        ar.add("bus");
    }
    public static int compareTo(ComparatorSubClass csc) {
        //ComparatorSubClass csc = new ComparatorSubClass();
        ComparatorSubClass csc1 = new ComparatorSubClass();
        int ret =csc1.compareTo(csc);
        return ret;
    }

    public static void main(String[] args) {
            //Comparator c = new Comparator();
        ComparatorSubClass csc = new ComparatorSubClass();
//        ComparatorSubClass csc1 = new ComparatorSubClass();
//        int ret =csc1.compareTo(csc);
        //System.out.println(ret );
        ComparatorSubClass.compareTo(csc);
    }


}


