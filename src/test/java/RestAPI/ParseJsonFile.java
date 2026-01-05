package RestAPI;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ParseJsonFile {
    @Test
    public void parseJsonFile() throws FileNotFoundException {
        File file=new File("./\\src\\main\\resources\\SampleJsonToParse.json");
        FileReader fr = new FileReader(file);

        ObjectMapper mapper = new ObjectMapper();
        //mapper.readValue(fr,ParseJsonFile.class);
    }
}
