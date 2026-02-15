package IBM_String_JavaPgms;

import java.util.regex.Pattern;

public class RemoveSpecialCharactersFromString {
    /**I/P--> Hello@123#World!
     * O/P--> Hello123World
     */
    public static void main(String[] args) {
        String str="Hello@123#World!";
        System.out.println("Original String: "+str);
        String regex="[^a-zA-Z0-9]";
        Pattern pattern = Pattern.compile(regex);
        pattern.matcher(str);
        String cleanStr=str.replaceAll(regex,"");
        System.out.println("Clean String is: "+cleanStr);
    }
}
