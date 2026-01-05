package RestAPI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import io.restassured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.common.mapper.TypeRef;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.Filter;
import io.restassured.http.*;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.*;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.security.KeyStore;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
public class SampleGetRequest {
    private String empName;
    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }


    public static void main(String[] args) throws JsonProcessingException {
//        RestAssured.baseURI="https://fakerestapi.azurewebsites.net";
//        String res = RestAssured.given()
//                .when()
//                .get("https://fakerestapi.azurewebsites.net/api/v1/Activities")
//                .then()
//                .log()
//                .all()
//                .toString();

        //System.out.println("Result is: "+res);
        // RestAssured.given().when().get

//        ValidatableResponse res = given().baseUri("https://fakerestapi.azurewebsites.net").basePath("/api/v1/Activities").log()
//                .uri().when().get().then().log().all();
//        List<Pojo_FakeRestApiEle> res = given()
//                .baseUri("https://fakerestapi.azurewebsites.net").basePath("/api/v1/Activities").log().uri()
//                .when()
//                .get().then().log().all().extract()
//                .as(new TypeRef<List<Pojo_FakeRestApiEle>>() {});
//        ObjectMapper mapper = new ObjectMapper();
//
//        List<Pojo_Projects> projects =
//                mapper.readValue(jsonString,
//                        new TypeReference<List<Pojo_Projects>>() {});

        //System.out.println(res.get(5).getTitle());

//        List<Pojo_Projects> res = given().baseUri("http://localhost:8084").basePath("/projects").log()
//                .uri().when().get().as(Pojo_Projects.class);

        //Handling Dynamic JSON Payload Using POJO
//        List<Pojo_Projects> res =
//                given()
//                        .baseUri("http://localhost:8084")
//                        .basePath("/projects")
//                        .log().uri()
//                        .when()
//                        .get()
//                        .then()
//                        .extract()
//                        .as(new TypeRef<List<Pojo_Projects>>() {});
//
//        System.out.println(res.get(1).getProjectName());

        String res = given()
                .baseUri("http://localhost:8084")
                .basePath("/projects")
                .log().uri()
                .when()
                .get()
                .then()
                //.extract().asString(); //Output in one line as String
                .extract().asPrettyString(); //Output as actual Json format
                       // .as(new TypeRef<List<Pojo_Projects>>() {})
        System.out.println("Response is: "+res);

        //Handling Dynamic JSON Payload Using Map without POJO
//        Map<String,Object> map =
//                given()
//                        .baseUri("http://localhost:8084")
//                        .basePath("/projects")
//                        .log().uri()
//                        .when()
//                        .get()
//                        .then()
//                        .extract()
//                        .as(new TypeRef<Map<String,Object>>() {});
//        System.out.println("Value of Map is: "+map);



        //res.get(1).getProjectName();

        //System.out.println("Result is: "+res.get(0).getProjectName());
//        SampleGetRequest sg=new SampleGetRequest();
//        sg.setEmpName("Shekhar");
//        ObjectMapper mapper=new ObjectMapper();
//        String json=mapper.writeValueAsString(sg);
//        System.out.println(json);
    }
}
