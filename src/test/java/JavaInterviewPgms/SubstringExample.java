package JavaInterviewPgms;

public class SubstringExample {

    public static void main(String[] args) {
        String s="ShekharAnand";
        String s1=s.substring(7);
        System.out.println(s1);
        String s2=s.substring(0,3);
        System.out.println(s2);
        CharSequence ch = s.subSequence(0, 3);
        System.out.println("Char Sequence: "+ch);
    }
}
