package IBM_String_JavaPgms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractingNumberFromRegexString_Type1 {
    public static void main(String[] args) {
        String s="Order ID: 12345, Amount: 6789, Ref: 999";
        //Extract all numbers from the string using regex

        // Define a regex pattern to match one or more digits in the string
        String regex="\\d+"; // "\\d+" matches one or more consecutive digits (0-9)

        // Compile the regex pattern into a Pattern object
        Pattern pattern=Pattern.compile(regex);

        // Create a Matcher object to find matches of the pattern in the input string 's'
        Matcher matcher=pattern.matcher(s);

        // Print a message indicating the start of number extraction
        System.out.println("Extracted numbers from the string:");

        // Use a while loop to find all matches of the pattern in the string
        while(matcher.find())
        {
            // Print each match (group of digits) found in the string
            System.out.println(matcher.group());
        }

    }
}
