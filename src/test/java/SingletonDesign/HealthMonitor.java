package SingletonDesign;

public class HealthMonitor {
    public HealthMonitor() {
    }

    private int heartRate;
    public int getHeartRate() {
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
        hm.setHeartRate(7);
        int speed=hm.getHeartRate();
        System.out.println("Speed is: "+speed);
    }
}
