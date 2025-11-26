package SeleniumFiles;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromJson {

    public static String readFromJson(String Key) throws IOException, ParseException {
        //Read input file
        FileReader fir = new FileReader("./\\src\\main\\resources\\Input.json");
        //Create java object
        JSONParser jparse = new JSONParser();
        Object javaObj = jparse.parse(fir);
        //Convert java object to JSon object (Downcasting)
        JSONObject obj = (JSONObject) javaObj;
        String value = obj.get(Key).toString();
        return value;
    }

    public static void main(String[] args) throws IOException, ParseException {
        String value=ReadFromJson.readFromJson("username");
        System.out.println("Value is: "+value);
    }
}
