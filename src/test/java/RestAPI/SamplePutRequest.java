package RestAPI;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class SamplePutRequest {
    public static void main(String[] args) {

        ValidatableResponse res = given().baseUri("https://fakerestapi.azurewebsites.net").basePath("/api/v1/Activities").log()
                .uri()
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"title\": \"string\",\n" +
                        "  \"dueDate\": \"2025-11-29T10:55:50.357Z\",\n" +
                        "  \"completed\": true\n" +
                        "}")
                .when()
                .get()
                .then()
                .log()
                .all();

        System.out.println("Result is: "+res);
        //given().when().get().then().app
    }
}
