package utils;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {

    public String getProperty(String key) throws IOException, ParseException {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        String fileName = "C:\\Projects\\Playwright\\src\\test\\resources\\Properties\\env.json";
        FileReader reader = new FileReader(fileName);

        //Read JSON file
        Object obj = jsonParser.parse(reader);
        JSONArray jsonArray = (JSONArray) obj;

        return (String) ((JSONObject) jsonArray.get(0)).get(key);
    }
}
