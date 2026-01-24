package JavaInterviewPgms;

public class RepeatEachCharacterTwice {

    public static void repeatTwice(String str)
    {
        StringBuilder sb=new StringBuilder();
        String newStr="";
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
           //newStr= newStr+sb.append(str.charAt(i)).toString();
            sb.append(ch).append(ch);
        }
        System.out.println("New String is: "+sb.toString());
    }

    public static void main(String[] args) {
        RepeatEachCharacterTwice.repeatTwice("Kite");
    }
}
