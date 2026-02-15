package IBM_String_JavaPgms;

import net.bytebuddy.dynamic.scaffold.MethodGraph;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateDateFormatUsingRegex {

    public static void main(String[] args) {
        String date1="2024-06-30";
        String date2="2024/06/30";
        String date3="2024.06.30";
        String date4="2024-6-30";
        String date5="24-06-30";

        String regex="\\d{4}[-/.]\\d{2}[-/.]\\d{2}";
        String regex1="^\\d{4}";
        Pattern pattern = Pattern.compile(regex1);
        Matcher matcher = pattern.matcher(date1);
        while (matcher.find())
        {
            System.out.println(matcher.group());
        }
        //when we have only one date to validate then we can directly use matches() method of String class
        System.out.println(date1.matches(regex));//if the result is true then the date format is valid otherwise invalid
        System.out.println(date2.matches(regex));
        System.out.println(date3.matches(regex));
        System.out.println(date4.matches(regex));
        System.out.println(date5.matches(regex));
    }

}
