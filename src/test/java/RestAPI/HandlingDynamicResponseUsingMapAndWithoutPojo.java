package RestAPI;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.common.mapper.TypeRef;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class HandlingDynamicResponseUsingMapAndWithoutPojo {
    public static void main(String[] args) throws IOException {
        File file = new File("./\\src\\main\\resources\\Json_Nested.json");
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(file,Map.class);
        //Map<String,Object> map = mapper.readValue(file, new TypeReference<Map<String, Object>>() {});
        
        System.out.println("Value of Map is: "+map);
        System.out.println(map.get("createdBy"));
        map.put("createdBy","Shekhar Anand");
        System.out.println("Value of Map is: "+map);
        System.out.println(map.get("createdBy"));
        //To print same as JSON Response
        String updated = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
        System.out.println("JSON is: "+"\n"+updated);

    }
}
