package MathodOverriding;

// Main class
public class OverrideDemo {
    public static void main(String[] args)
    {
        Calculator calc1 = new Calculator();
        System.out.println("Result: "
                + calc1.my_Sum(5, 10));

        AdvancedCalculator calc2 = new AdvancedCalculator();
        System.out.println("Result: "
                + calc2.my_Sum(5, 10));

        // Polymorphism example
        Calculator calc3 = new AdvancedCalculator();
        System.out.println("Result: "
                + calc3.my_Sum(5, 10));
    }
}