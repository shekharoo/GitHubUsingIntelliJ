package MathodOverriding;

// Child class
class AdvancedCalculator extends Calculator{

    // Overriding the my_Sum method
    @Override int my_Sum(int a, int b){

        System.out.println(
                "Child class overridden sum method:");
        // Adding custom behavior
        return a + b
                + 10; // adds extra 10 for demonstration
    }
}