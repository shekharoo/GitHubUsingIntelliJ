import java.util.Arrays;

public class AnagramPgm {
    public static boolean anagramCheck(String s, String s1)
    {
        boolean flag=false;
       if(s.length()!=s1.length())
       {
           flag = false;

       }
       if(s.length()==s1.length())
       {
           char[] ch = s.toCharArray();
           char[] ch1= s1.toCharArray();
           Arrays.sort(ch);
           Arrays.sort(ch1);
           if(Arrays.equals(ch,ch1));
           {
               flag=true;
           }
       }

        return flag;
    }

    public static void main(String[] args) {
        String s="poti";
        String s1="top";
        System.out.println("Is Anagram: "+AnagramPgm.anagramCheck(s,s1));
    }
}
