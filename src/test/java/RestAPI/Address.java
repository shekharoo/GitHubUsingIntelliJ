package RestAPI;

import java.util.List;

public class Address {


    private String city;

    private String country;
    private int houseNo;
    private String state;
    private String streetName;
    private List<Landmark> landmarkList;
    public void setLandmarkList(List<Landmark> landmarkList) {
        this.landmarkList = landmarkList;
    }



    public List<Landmark> getLandmarkList() {
        return landmarkList;
    }



    public void setCity(String city) {
        this.city = city;
    }
    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }


    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public String getState() {
        return state;
    }

    public String getStreetName() {
        return streetName;
    }




}
