package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
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

    public void parseToList(String path, List<String> keyNames, List<List<String>> valueLists) throws Exception{
        Object obj = new JSONParser().parse(new FileReader(path));
        JSONObject jo = (JSONObject) obj;
        Set<String> keySet = jo.keySet();
        for(String s: keySet) {
            keyNames.add(0, "\"" + s + "\"");
            List<?> tempList = (List<?>) jo.get(s);
            List<String> stringList = new ArrayList<String>();
            for (int i = 0; i < tempList.size(); i++) {
                if (tempList.get(i) == null) {
                    stringList.add("null");
                } else {
                    if (tempList.get(i).getClass().getName().equals("java.lang.String")) {
                        stringList.add("\"" + tempList.get(i) + "\"");
                    } else {
                        stringList.add(String.valueOf(tempList.get(i)));
                    }
                }
            }
            valueLists.add(0, stringList);
        }
    }

}
