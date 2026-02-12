package LeetCode;

public class RemoveDuplicateInString {
    public static StringBuilder removeDuplicate(String s)
    {
        StringBuilder s1 =new StringBuilder(s);
        StringBuilder s2=new StringBuilder();
        //String s1="";
        for(int i=0;i<s1.length()-1;i++)
        {
            if(s1.charAt(i)!=s1.charAt(i+1))
            {
                s2.append(s1.charAt(i));
            }
        }
        System.out.println(s2);
        return s2;
    }
    public static void main(String[] args) {
        RemoveDuplicateInString.removeDuplicate("aabbcccdefg");

    }
}
