package test;

import utils.BodyJSONParser;
import utils.JSONGenerator;
import utils.RequestBodyRenerator;

import java.io.IOException;
import java.util.*;

public class GeneratorTest {
    public static void main(String[] args) throws Exception {
        RequestBodyRenerator mg = new RequestBodyRenerator();
//        String[] keyArray = new String[]{
//                "\"attachment_id\"",
//                "\"beacon_type\"",
//                "\"uuid\"",
//                "\"major\"",
//                "\"minor\"",
//                "\"check_location\""
//        };
//
//
//        String[] value0Array = new String[]{
//                "null",
//                "100",
//                "200"
//        };
//        String[] value1Array = new String[]{
//                "\"eUID\"",
//                "\"iBcn\"",
//                "\"aaa\""
//        };
//        String[] value2Array = new String[]{
//                "\"D9B9EC1F-3925-43D0-80A9-1E39D4CEA95C\"",
//                "\"D9B9EC1F4CEA95C\"",
//                "12345"
//        };
//        String[] value3Array = new String[]{
//                "\"B9407F3025556B57FE6D\"",
//                "\"asidjfiajdf\""
//        };
//        String[] value4Array = new String[]{
//                "\"F5F8466EAFF9\"",
//                "\"oidjfidjfi\""
//        };
//        String[] value5Array = new String[]{
//                "true",
//                "false",
//                ""
//        };

        String pathName = "C:\\Users\\mzong\\Desktop\\bodyData.json";
        List<String> keys = new ArrayList<String>();
        List<List<String>> values = new ArrayList<List<String>>();
        BodyJSONParser bodyJSONParser = new BodyJSONParser();
        bodyJSONParser.parseToList(pathName, keys, values);

        List<String> envValues0 = mg.generateResultList(keys, values);
        List<String> envValues1 = Arrays.asList("\"93\"", "\"94\"", "\"50\"", "\"200\"");

        List<List<String>> envValues = Arrays.asList(envValues0, envValues1);
        List<String> envNames = Arrays.asList("body", "beaconid");

        JSONGenerator jsonGenerator = new JSONGenerator();
        jsonGenerator.generate(envNames, envValues);
    }
}
