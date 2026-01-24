package JavaInterviewPgms;

public class DesiredOutput {
    public static void Demo()
    {
        StringBuilder sb=new StringBuilder("Shekhar");
        //sb.insert(1,"ZY");
        sb.replace(1,3,"ZXYXZ");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        DesiredOutput.Demo();
    }
}
