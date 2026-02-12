package LeetCode;

public class VowelLeftConsonantRight {
    public static String modifyString(String s)
    {
        char[] ch=s.toCharArray();
        int vowel=0;
        int consonant=ch.length-1;
        char temp=' ';
        char[] ch1= new char[ch.length];
        for(int i=0;i<ch.length-1;i++)
        {
            if(ch[i]=='a'||ch[i]=='e'||ch[i]=='i'||ch[i]=='o'||ch[i]=='u')
            {
                //temp=ch[i];
                ch1[vowel]=ch[i];
                //ch[]=ch[vowel];
                vowel++;
            }
            else {
                //temp=ch[i];
                ch1[consonant]=ch[i];
                //ch[consonant]=temp;
                consonant--;
            }
        }
        System.out.println("String is: "+String.valueOf(ch1));
        return String.valueOf(ch1);
    }

    public static void main(String[] args) {
        VowelLeftConsonantRight.modifyString("ratebipeomuo");
    }
}
