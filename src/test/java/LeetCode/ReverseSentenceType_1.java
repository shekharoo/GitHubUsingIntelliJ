package LeetCode;

public class ReverseSentenceType_1 {
    public static void main(String[] args) {
        String s = "My Name is Shekhar Anand";
        //yM emaN si rahkehS dnanA
        StringBuilder result=new StringBuilder();
        String[] sSplit=s.split(" ");
        //for(String s1:sSplit)
        for(int i=0;i<sSplit.length;i++)
        {
            StringBuilder sb=new StringBuilder(sSplit[i]);
            result.append(sb.reverse()).append(" ");
        }
        System.out.println(result);
    }
}
