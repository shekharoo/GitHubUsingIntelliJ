package SingletonDesign;

public class HealthMonitor {
    private HealthMonitor() {
    }

    private static int heartRate;
   private static int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public static HealthMonitor getInstance()
    {
        HealthMonitor obj=null;
        if(obj==null)
        {
            obj= new HealthMonitor();
        }
            return obj;
    }

    public static void main(String[] args) {
        HealthMonitor hm=HealthMonitor.getInstance();
        System.out.println(hm.hashCode());
        HealthMonitor hm1=HealthMonitor.getInstance();
        System.out.println(hm1.hashCode());
//        hm.setHeartRate(7);
//        int speed=hm.getHeartRate();
//        System.out.println("Speed is: "+speed);
    }
}
