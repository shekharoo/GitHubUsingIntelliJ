package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class ReverseSentence {
    public static void main(String[] args) {
//        String s="My Name is Shekhar Anand"; //
//        StringBuilder str =new StringBuilder(s);
//        String[] sSplit=s.split(" ");
//        System.out.println("Size is: "+sSplit.length);
//        for(int i=sSplit.length-1;i>=0;i--)
//        {
//            System.out.print(sSplit[i]+" ");
//        }
//
//        Set<String> strSet=new HashSet<>();
        StringBuilder json = new StringBuilder();
        json.append("{")
                .append("\"id\":").append(12546).append(",")
                .append("\"name\":\"").append("Shekhar").append("\"")
                .append("}");
        System.out.println(json);
    }
}
