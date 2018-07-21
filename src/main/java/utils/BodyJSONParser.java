package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.FileReader;
import java.util.List;
import java.util.Set;

public class BodyJSONParser {
    public void parseToList(String path, List<String> keyNames, List<List<String>> valueLists) throws Exception{
        Object obj = new JSONParser().parse(new FileReader(path));
        JSONObject jo = (JSONObject) obj;
        Set<String> keySet = jo.keySet();
        for(String s: keySet) {
            keyNames.add(0, s);
            List<String> tempList = (List<String>) jo.get(s);
            valueLists.add(0, tempList);
        }
    }
}
