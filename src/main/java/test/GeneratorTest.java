package test;

import utils.BodyJSONParser;
import utils.JSONGenerator;
import java.util.*;

public class GeneratorTest {
    public static void main(String[] args) throws Exception {

        BodyJSONParser bodyJSONParser = new BodyJSONParser();

        List<String> envValues0 = bodyJSONParser.generateList("bodyData.json");
        //List<String> envValues2 = Arrays.asList("\"Old offer\"", "\"Very good offer\"", "100");
        List<String> envValues1 = bodyJSONParser.generateList("attachmentPatchBody.json");

        List<List<String>> envValues = Arrays.asList(envValues0, envValues1);
        List<String> envNames = Arrays.asList("body", "attachmentPatchBody");

        JSONGenerator jsonGenerator = new JSONGenerator();
        jsonGenerator.generate(envNames, envValues, "c:\\Users\\mzong\\Desktop\\test.json");
    }
}
