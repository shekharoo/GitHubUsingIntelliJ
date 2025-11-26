public class PalindromeInt {
    public static int longestPalindrome(int i) {//121
        int rev = 0;
        while (i > 0)
        {
            rev = rev * 10 + i % 10;//1
            i = i / 10;//12


    }
        return rev;
}
    public static void main(String[] args) {
        int pal= PalindromeInt.longestPalindrome(121);
        //System.out.println("Palindrome is: "+pal);
        int i=12;
        int j=i%10;
        System.out.println("j value: "+j);
    }
    }
