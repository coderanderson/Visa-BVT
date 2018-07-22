package test;

import utils.BodyJSONParser;
import utils.JSONGenerator;
import java.util.*;

public class GeneratorTest {
    public static void main(String[] args) throws Exception {

        BodyJSONParser bodyJSONParser = new BodyJSONParser();

        List<String> envValues0 = bodyJSONParser.generateList("bodyData.json");
        List<String> envValues1 = Arrays.asList("\"93\"", "\"94\"", "\"50\"", "\"200\"");
        List<String> envValues2 = bodyJSONParser.generateList("c:\\Users\\mzong\\Desktop\\itineraryBody.json");

        List<List<String>> envValues = Arrays.asList(envValues0, envValues1, envValues2);
        List<String> envNames = Arrays.asList("body", "beaconid", "itineraryBody");

        JSONGenerator jsonGenerator = new JSONGenerator();
        jsonGenerator.generate(envNames, envValues, "c:\\Users\\mzong\\Desktop\\test.json");
    }
}
