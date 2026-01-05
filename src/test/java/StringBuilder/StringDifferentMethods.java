package StringBuilder;

import org.testng.annotations.Test;

public class StringDifferentMethods {
    //public static void main(String[] args) {
    @Test  //I/P-->Shekhar is good person
           // O/P--> rahkehS si doog nosrep
    public void StringReverse()
    {
        //StringBuilder sb=new StringBuilder("Shekhar is good person");
        String str="Shekhar is good person";
        String[] splitStr = str.split(" ");
        System.out.println("Size is: "+splitStr.length);
        StringBuilder sb = new StringBuilder(splitStr[0]);
        System.out.println(sb.reverse());
        StringBuilder sb1 = new StringBuilder(splitStr[1]);
        System.out.println(sb1.reverse());
        StringBuilder sb2 = new StringBuilder(splitStr[2]);
        System.out.println(sb2.reverse());
        StringBuilder sb3 = new StringBuilder(splitStr[3]);
        System.out.println(sb3.reverse());
        System.out.println(sb+" "+sb1+" "+sb2+" "+sb3);
        //sb.insert(1,"M");
        //System.out.println("New String is: "+sb);
    }
    @Test  //I/P-->Shekhar is good person
    // O/P-->      person good is Shekhar
    public void StringReverse1()
    {
        //StringBuilder sb=new StringBuilder("Shekhar is good person");
        String str="Shekhar is good person";
        String[] splitStr = str.split(" ");
        System.out.println("Size is: "+splitStr.length);
//        StringBuilder sb = new StringBuilder(splitStr[0]);
//        System.out.println(sb.reverse());
//        StringBuilder sb1 = new StringBuilder(splitStr[1]);
//        System.out.println(sb1.reverse());
//        StringBuilder sb2 = new StringBuilder(splitStr[2]);
//        System.out.println(sb2.reverse());
//        StringBuilder sb3 = new StringBuilder(splitStr[3]);
//        System.out.println(sb3.reverse());
        System.out.println(splitStr[3]+" "+splitStr[2]+" "+splitStr[1]+" "+splitStr[0]);
        //sb.insert(1,"M");
        //System.out.println("New String is: "+sb);
    }
}
