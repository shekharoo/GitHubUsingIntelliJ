package IBM_String_JavaPgms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractNumbersfromStringandSumThem {
    public static void main(String[] args) {
        String s="abc12xyz3k9";
        String regex="\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        int sum=0;
        while(matcher.find())
        {
            int no=Integer.parseInt(matcher.group());
            System.out.println(matcher.group());
            sum=sum+no;

        }
        System.out.println("Sum is: "+sum);
    }
}
