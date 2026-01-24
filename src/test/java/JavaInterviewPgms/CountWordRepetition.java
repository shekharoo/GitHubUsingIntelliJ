package JavaInterviewPgms;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

public class CountWordRepetition {
    public static void countWordRepetition(String str)
    {
        StringBuilder sb=new StringBuilder();
        int count=1;
        char[] ch=str.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            if(ch[i]==ch[i+1])
            {
                count++;
                //System.out.print(sb.append(str.charAt(i))+""+count);
            }
            else{
                sb.append(str.charAt(i)).append(count);
                count=1;
            }

        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        countWordRepetition("aabccdde");
    }
}
