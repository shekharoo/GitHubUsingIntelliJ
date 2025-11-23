package Inheritance;

public class ChildClass extends ParentClass{
    private int i=10;
    static int a = 10;
    int b = 20;
    final int c=40;
    ChildClass()
    {
        //super();
        System.out.println("This is Child class constructor");
    }
    public static void dailyRun(String path, int km)
    {
        System.out.println("This is daily run method of Parent class");
    }
    public void run(String path, int km)
    {
        System.out.println("This is run method of Child class");
        //super.run("Domuhan",10);
    }

    public static void main(String[] args) {
        ChildClass c = new ChildClass();
        c.run("Domuhan",10);
        ParentClass p = new ChildClass();
        p.run("Domuah",10);
        p = (ParentClass)new ChildClass();
        int a1 = p.b;
        System.out.println("a value: "+a1);
        p.run("Dom",20);
        System.out.println("Printing final value method of Parent class");
        p.dailyRun1("Dom",20);
        //Next is Final concept
        System.out.println("Parent C final value: "+p.c);
        System.out.println("Child C final value: "+c.c);

        System.out.println("=======Final local variable=======");
        final int i;
        //System.out.println("Printing private value of Parent class: "+p.i);
        //i=10;
        //System.out.println("Final local value: "+i);
        System.out.println("Printing private value of Child class: "+c.i);

        System.out.println("========Accessing Interface=======");
        p.run("Do",10);

    }

}
