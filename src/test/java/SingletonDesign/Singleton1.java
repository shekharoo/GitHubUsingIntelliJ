package SingletonDesign;

public class Singleton1 {
    //private Constructor
    private Singleton1(){

    }

    //private instance of class
    private static Singleton1 sign;
    //a public static method that returns the single instance of the class.
    // This method is responsible for creating the instance if it doesn't already exist
    // (lazy initialization) and returning it.
    public static Singleton1 getInstance()
    {
        if(sign==null)
        {
            sign = new Singleton1();
        }
        return sign;
    }

    public static void main(String[] args) {
        //Singleton1 sign = new Singleton1();
        //
        sign=Singleton1.getInstance();
        Singleton1 sign1 = Singleton1.getInstance();
        System.out.println(sign.hashCode());
        System.out.println(sign1.hashCode());
        System.out.println(sign==sign1);
    }

}
