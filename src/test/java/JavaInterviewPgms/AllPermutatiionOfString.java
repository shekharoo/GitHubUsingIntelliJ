package JavaInterviewPgms;

public class AllPermutatiionOfString {
    public static String permutation(String s,String ans) {
        String rem=null;
        if (s.length() == 0) {
            System.out.println(ans);
        }
        for (int i = 0; i < s.length(); i++) {
            //System.out.println(s.substring(0, i)+s.substring(i+1)+s.charAt(i));
            //permutation(s);

            System.out.println("1st part: "+s.substring(0, i));
            System.out.println("2nd part: "+s.substring(i+1));
            rem=s.substring(0, i)+s.substring(i+1);
            System.out.println("Remaining: "+rem);
            //r=rem+s.charAt(i);
            permutation(rem,ans+s.charAt(i));
        }
        System.out.println(rem);
        return rem;
    }

    public static void main(String[] args) {
        String str="abc";
        AllPermutatiionOfString.permutation(str,"");
//        String s = str.substring(0, 1);
//        System.out.println(s);
//        String s1 = str.substring(1 + 1);
//        System.out.println(s1);
//        System.out.println(s+s1);
    }
}
