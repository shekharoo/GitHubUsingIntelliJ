package IBM_String_JavaPgms;

public class StringCompression {
    /**
     * Input: aaabbccaa
     * Output: a3b2c2a2
     *
     * Input: abc
     * Output: abc
     *
     * Input: aabbcc
     * Output: a2b2c2
     *
     * Input: aaaa
     * Output: a4
     */
    public static void StringCompression(String s)
    {
        StringBuilder sb=new StringBuilder();
        int count=1;
        for(int i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
            {
                count++;
            }
            else {
                sb.append(s.charAt(i));
                if(count>1)
                {
                    sb.append(count);
                }
                count=1;
            }
            //To append last character
        }
        sb.append(s.charAt(s.length()-1));
        if(count>1)
        {
            sb.append(count);
        }
        System.out.println(sb);
    }
    public static void main(String[] args) {
        StringCompression.StringCompression("aaabbccaa");
    }
}
