package Strings;

public class Upper_LowerCasePgm {
    public static void main(String[] args) {
        String s ="Shekhar";
        char c=(char)(s.charAt(1)-32); // h if subtract (-32) it becomes UpperCase
        char c2=(char)(s.charAt(0)+32); // S if add (+32) it will become lower case
        System.out.println("Character is: "+c);
        System.out.println("Character is: "+c2);
    }
}
