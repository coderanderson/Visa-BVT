package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BodyJSONParser {

    public List<String> generateList(String pathName) throws Exception {
        List<String> keys = new ArrayList<String>();
        List<List<String>> values = new ArrayList<List<String>>();
        parseToList(pathName, keys, values);
        RequestBodyRenerator mg = new RequestBodyRenerator();
        List<String> res = mg.generateResultList(keys, values);
        return res;
    }

    private void parseToList(String path, List<String> keyNames, List<List<String>> valueLists) throws Exception{
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
