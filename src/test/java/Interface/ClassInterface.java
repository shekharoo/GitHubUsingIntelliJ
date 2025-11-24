package Interface;

public class ClassInterface implements InterfaceParent{
    public void dailyRun(String path)
    {
        System.out.println("Daily run of Child subclass");
    }
    public static void main(String[] args) {
        InterfaceParent ip = new ClassInterface();
        System.out.println(ip.i);
        InterfaceParent.dailyRun("DO");
        //ip.i=20;
        ClassInterface ci = new ClassInterface();
        ci.dailyRun("DO");

    }
}
