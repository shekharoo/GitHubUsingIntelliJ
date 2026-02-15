package JavaInterviewPgms;

public class StringRemoveSpace {
    public static void removeSpace(String str)
    {
        StringBuilder res=new StringBuilder();
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)!=' ')
            {
                res.append(str.charAt(i));
            }
        }
        System.out.println("String is: "+res.toString());
    }

    public static void main(String[] args) {
        StringRemoveSpace.removeSpace("Java Selenium");
    }

}
