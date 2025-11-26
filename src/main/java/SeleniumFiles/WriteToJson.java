package SeleniumFiles;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class WriteToJson {

    public static void writeToJson(String Key,String Value) throws IOException, ParseException {
        //Read input file
        FileReader fir = new FileReader("./\\src\\main\\resources\\Input.json");
        //Create java object
        JSONParser jparse = new JSONParser();
        Object javaObj = jparse.parse(fir);
        //Convert java object to JSon object (Downcasting)
        JSONObject obj = (JSONObject) javaObj;
        obj.put(Key,Value);
        System.out.println("Successfully written to JSON file!");

//        String value = obj.get(Key).toString();
//        return value;
    }

    public static void main(String[] args) throws IOException, ParseException {
        WriteToJson.writeToJson("Browser","Chrome");
    }
}
