package AbstractionClass;

public class AbstarctionDemoChild extends  AbstractionDemo{

        public void run(String path)
        {
            AbstarctionDemoChild adc = new AbstarctionDemoChild();
            System.out.println("Implementation of Abstract method of Parent in child class");

        }

    public static void main(String[] args) {
        AbstarctionDemoChild adc = new AbstarctionDemoChild();
        adc.run("Do");

    }

}
