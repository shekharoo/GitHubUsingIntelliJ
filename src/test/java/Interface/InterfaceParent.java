package Interface;

public abstract interface InterfaceParent {
    public interface Run
    {
      abstract public void run(String path);
    }
    public static void dailyRun(String path)
    {
        System.out.println("Daily run of Parent class");
    }
    int i=10;


}
