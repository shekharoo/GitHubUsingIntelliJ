package Inheritance;

public class ParentClass {

    ParentClass(){
        System.out.println("This is Parent class constructor");
    }
    interface run
    {
        public void run(String path);
        final static int j=10;
    }
    //final int i;
    private int i=10;
    public interface myInterface{
        void address(String city, int pin);
        public String name(String name,int age);

    }
    static int a = 10;
    int b = 20;
    final int c=30;
    final public static void dailyRun1(String path, int km)
    {
        System.out.println("This is daily run method of Parent class");
    }
    public void run(String path, int km)
    {
        System.out.println("This is run method of Parent class");
    }

}
