package RestAPI;
import io.restassured.*;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
public class SampleGetRequest {
    public static void main(String[] args) {
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

        ValidatableResponse res = given().baseUri("https://fakerestapi.azurewebsites.net").basePath("/api/v1/Activities").log()
                .uri().when().get().then().log().all();

        System.out.println("Result is: "+res);
    }
}
