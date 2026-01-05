package RestAPI;

//import io.restassured.RestAssured;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class JsonArrayPayloadDiffApproach {
    public static void main(String[] args) throws IOException {
        //Using Json array payload by POJO class
//        Pojo_Projects proj=new Pojo_Projects();
//        proj.setCreatedBy("Anand");
//        proj.setCreatedOn("02/01/2026");
//        proj.setProjectId("Scorp-456");
//        proj.setProjectName("WholesaleMarker");
//        proj.setStatus("InProgress");
//        proj.setTeamSize(10);
//
//        RestAssured.given().contentType(ContentType.JSON)
//                .body(proj).log().all()
//                .when().post("http://localhost:8084/addProject").then().log().all();

        //Using JSON Array Payload with Nested POJO
        Pojo_Projects proj=new Pojo_Projects();
        proj.setCreatedBy("Anand");
        proj.setCreatedOn("02/01/2026");
        proj.setProjectId("Scorp-456");
        proj.setProjectName("WholesaleMarker");
        proj.setStatus("InProgress");
        proj.setTeamSize(10);

        Address a = new Address();
        a.setCity("Gaya");
        a.setCountry("India");
        a.setHouseNo(409);
        a.setState("Bihar");
        a.setStreetName("Domuhan");

        Address a1 = new Address();
        a1.setCity("BodhGaya");
        a1.setCountry("India");
        a1.setHouseNo(410);
        a1.setState("Bihar");
        a1.setStreetName("Domuhan");

        List<Address> list = new ArrayList<>();
        list.add(a);
        list.add(a1);

        //List<List<Landmark>> lm=new ArrayList<>();

        Landmark landmark = new Landmark();
        landmark.setLongitude(2512542633.025322);
        landmark.setLatitude(84578965.225663321);
        landmark.setNearBy("Idea Tower");
        landmark.setRoadNo(2);

        Landmark landmark1 = new Landmark();
        landmark1.setLongitude(2512745885.0253282);
        landmark1.setLatitude(845784785.225665203);
        landmark1.setNearBy("Siddhartha");
        landmark1.setRoadNo(3);
        List<Landmark> landList = new ArrayList<>();
        landList.add(landmark);
        landList.add(landmark1);
        a.setLandmarkList(landList);
        a1.setLandmarkList(landList);

//        Address add=new Address();
//        add.setLandmarkList(landList);
//
//
//
//
//        List<Address> lnls = new ArrayList<>();
//        lnls.add(add);
        //list.add(add);

        //System.out.println("List is: "+list.get(1).getHouseNo());
        proj.setAddress(list);
        //proj.setAddress(lnls);

        ObjectMapper mapper = new ObjectMapper();
        File file = new File("./\\src\\main\\resources\\Json_Nested.json");
        Pojo_Projects body = mapper.readValue(file, Pojo_Projects.class);
        body.getAddress().get(0).getLandmarkList().get(0).getNearBy();
//        String jsonBody = mapper.writeValueAsString(body);
        System.out.println("JSON value is: "+body.getAddress().get(0).getLandmarkList().get(0).getNearBy());


//        RestAssured.given().contentType(ContentType.JSON)
//                .body(body).log().body()
//                //.when().get();
//                .when().post("http://localhost:8084/addProject").then().log().all();
        Map<String,Object> map = RestAssured.given().contentType(ContentType.JSON)
                .body(body).log().body()
                //.when().get();
                .when().post("http://localhost:8084/addProject").as(Map.class);
        System.out.println("Map value is: "+map);
    }
}
