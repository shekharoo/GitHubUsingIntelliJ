package AbstractionClass;

public abstract class AbstractionDemo {
    AbstractionDemo() {
        System.out.println("This is constructor of Abstraction Demo class");
    }

    abstract public void run(String path);
    public void dailyRun(String path, int km)
    {
        System.out.println("Daily run..");
    }

    //public static void main(String[] args) {
        //AbstractionDemo ad = new AbstractionDemo()
//        {
//            @Override
//            public void run(String path, int km)
//            {
//                System.out.println("Run method implementation of abstract in main() method");
//            }
//        };
       // ad.run("Do",10);
   // }
}
