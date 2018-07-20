package utils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BodyJSONParser {
    public void parseToList(String path, List<String> keyNames, List<List<String>> valueLists) throws Exception{
        Object obj = new JSONParser().parse(new FileReader(path));
        JSONObject jo = (JSONObject) obj;
        Set<String> keySet = jo.keySet();
        for(String s: keySet) {
            valueLists.add((List<String>) jo.get(s));
        }
        for(List<String> l: valueLists) {
            for(String s: l) {
                System.out.println(s);
            }
        }
    }
}
