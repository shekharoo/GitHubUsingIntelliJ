package IBM_String_JavaPgms;

public class RemoveDuplicateCharacters {

    public static void main(String[] args) {
        String s1="abbccdeffgg";
        //char[] ch=s.toCharArray();
//        for(int i=0;i<s.length()-1;i++)
//        {
//            for(int j=i+1;j<s.length();j++)
//            {
//                if(s.charAt(i)==s.charAt(j));
//                System.out.println(s.charAt(i));
//            }
//        }
        String s="abbccdeffgg";   //O/P--> and
        for(int i=0;i<s.length()-1;i++)
        {
            for(int j=i+1;j<s.length();j++)
            {
                if(s.charAt(i)==s.charAt(j))
                {
                    System.out.println(s.charAt(i));
                }
            }
        }

    }
}
