package test;

import utils.BodyJSONParser;
import utils.JSONGenerator;
import utils.RequestBodyRenerator;

import java.io.IOException;
import java.util.*;

public class GeneratorTest {
    public static void main(String[] args) throws Exception {
        RequestBodyRenerator mg = new RequestBodyRenerator();

        String pathName = "bodyData.json";
        List<String> keys = new ArrayList<String>();
        List<List<String>> values = new ArrayList<List<String>>();
        BodyJSONParser bodyJSONParser = new BodyJSONParser();
        bodyJSONParser.parseToList(pathName, keys, values);

        List<String> envValues0 = mg.generateResultList(keys, values);
        List<String> envValues1 = Arrays.asList("\"93\"", "\"94\"", "\"50\"", "\"200\"");

        List<List<String>> envValues = Arrays.asList(envValues0, envValues1);
        List<String> envNames = Arrays.asList("body", "beaconid");

        JSONGenerator jsonGenerator = new JSONGenerator();
        jsonGenerator.generate(envNames, envValues, "/Users/mzong/Desktop/test.json");
    }
}
