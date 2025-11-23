package Strings;

public class OccurenceofCharacters {

    public static void occurenceOfCharacters(String s)
    {

        char[] charA = s.toCharArray();
        for(int i=0;i<charA.length;i++)
        {
            int count = 0;
            for(int j=1;j<charA.length;j++)
            {
                if(charA[i]==charA[j])
                {
                    count++;
                }
            }
            System.out.println("Count for "+charA[i]+" is: "+count);
        }
    }

    public static void main(String[] args) {
        String s = "success";
        OccurenceofCharacters.occurenceOfCharacters(s);
    }
}
