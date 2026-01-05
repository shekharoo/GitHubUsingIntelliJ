package RestAPI;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pojo_Projects {

    public String getCreatedBy() {
        return createdBy;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getStatus() {
        return status;
    }

    public int getTeamSize() {
        return teamSize;
    }

    private String createdBy;
    private String createdOn;

    public List<Address> getAddress() {
        return address;
    }

    private List<Address> address;

    public void setAddress(List<Address> address) {
        this.address = address;
    }



    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    private String projectId;
    private String projectName;
    private String status;
    private int teamSize;

}
