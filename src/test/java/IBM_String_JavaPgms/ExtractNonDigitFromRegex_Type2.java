package IBM_String_JavaPgms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractNonDigitFromRegex_Type2 {
    /**
     * Input: "abc123def456ghi789"
     * Output: abSc dMef ghi
     * \d → digit (0–9)
     *
     * \D → NOT a digit
     */
    public static void main(String[] args) {
        String s="abSc123dMef456ghi789";
        //String regex="[a-zA-Z]+";
        String regex="\\D+";   //matches one or more non-digit characters
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        while(matcher.find())
        {
            System.out.print(matcher.group()+" ");
        }
    }


}
