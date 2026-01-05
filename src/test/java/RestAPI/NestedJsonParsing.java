package RestAPI;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;

public class NestedJsonParsing {

    public static void NestedJsonParsing()
    {

    }

    public static void main(String[] args) {
//        String res = RestAssured.given().baseUri("https://dummyjson.com/")
//                .basePath("/carts").log().uri()
//                .when()
//                .get()
//                .then().log().all().extract().response().asString();
        String res = RestAssured.given().baseUri("https://dummyjson.com/")
                .basePath("/carts").log().uri()
                .when()
                .get()
                //.then().log().all().extract().response().jsonPath();
        .then().log().all().extract().response().asString();
        System.out.println(res);

        JsonPath jp=new JsonPath(res);
        int id=jp.getInt("carts.id[0]");
        System.out.println("Id is: "+id);
        String title=jp.getString("carts[18].products[1].title");
        System.out.println("Title is: "+title);
        //String title=jp.getString("carts[14].products[1].title");
        String limit=jp.getString("limit");
        System.out.println("Title is: "+limit);
        //(JsonObject)res.
//        JSONObject obj = (JSONObject) res;
//        String value = obj.get(Key).toString();

//        System.out.println(res);
//        ObjectMapper mapper= new ObjectMapper();
//        mapper.createParser(res);
    }
}
