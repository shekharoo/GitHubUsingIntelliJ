package IBM_String_JavaPgms;

public class ReverseWordsinaSentenceWithoutUsingsplit {

    /**
     * I am found of automation
     * Output:
     * automation of found am I
     */
    public static void main(String[] args) {
        String s = "I am found of automation";
        StringBuilder sb = new StringBuilder();
        //sb.appe
        int end = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                sb.append(s.substring(i + 1, end)).append(" ");
                end = i;
            }
        }
        sb.append(s.substring(0, end));
        System.out.println(sb);
    }
}
