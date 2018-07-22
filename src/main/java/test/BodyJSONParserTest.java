package test;

import utils.BodyJSONParser;

import java.util.ArrayList;
import java.util.List;

public class BodyJSONParserTest {
    public static void main(String[] args) throws Exception{
        String pathName = "C:\\Users\\mzong\\Desktop\\bodyData.json";
        List<String> keyList = new ArrayList<String>();
        List<List<String>> valueLists = new ArrayList<List<String>>();
        BodyJSONParser bodyJSONParser = new BodyJSONParser();
        //bodyJSONParser.parseToList(pathName, keyList, valueLists);
    }
}
