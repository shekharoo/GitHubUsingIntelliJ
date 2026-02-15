package IBM_String_JavaPgms;

public class FindAllPermutationsofaString {

        public static void permute(String str, String result) {

            // Base case
            if (str.length() == 0) {
                System.out.println(result);
                return;
            }

            for (int i = 0; i < str.length(); i++) {

                // Pick character
                char current = str.charAt(i);

                // Remaining string
                String remaining = str.substring(0, i) + str.substring(i + 1);

                // Recursive call
                permute(remaining, result + current);
            }
        }

        public static void main(String[] args) {
            String input = "ABC";
            permute(input, "");
        }
    }
