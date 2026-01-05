package RestAPI;

public class Landmark {
    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getNearBy() {
        return nearBy;
    }

    public int getRoadNo() {
        return roadNo;
    }

    private double latitude;

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setNearBy(String nearBy) {
        this.nearBy = nearBy;
    }

    public void setRoadNo(int roadNo) {
        this.roadNo = roadNo;
    }

    private double longitude;
    private String nearBy;
    private int roadNo;
}
