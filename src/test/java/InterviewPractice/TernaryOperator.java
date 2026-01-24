package InterviewPractice;

public class TernaryOperator {
    //1 static variable
    static int a;
    //2 static method
    static void display()
    {
        System.out.println("Inside static method");
    }
    //3
    static
    {
        System.out.println("Inside static initializer block");
    }
    //4
    int b;
    //5 static method
    void display1()
    {
        System.out.println("Inside non-static method");
    }
    //6
    static
    {
        System.out.println("Inside non-static initializer block");
    }
    TernaryOperator()
    {
        System.out.println("Inside constructor..");
    }
    public static void main(String[] args) {
//        int a=60;
//        int b=35;
//        int c=20;
//        int great = (a > b)
//                ? (a > c ? a : c)
//                : (a > b ? a : b);
//        System.out.println("Result is: "+great);
//        int a=60;
//        int b=35;
//        int c = Math.max(a, b);
//        System.out.println("Output is: "+c);
//        String str="Shekhar";
//        String str1="";
//        for(int i=str.length()-1;i>=0;i--)
//        {
//            str1=str1+str.charAt(i);
//        }
//        System.out.println("Reverse String is: "+str1);
        display();
        System.out.println("Static Value is: "+a);

        TernaryOperator o = new TernaryOperator();
        System.out.println("Value is: "+o.b);
        o.display1();

    }
}
