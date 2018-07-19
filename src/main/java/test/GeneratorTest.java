package test;

import utils.JSONGenerator;
import utils.RequestBodyRenerator;

import java.io.IOException;
import java.util.*;

public class GeneratorTest {
    public static void main(String[] args) throws IOException {
        RequestBodyRenerator mg = new RequestBodyRenerator();
        String[] keyArray = new String[]{
                "\"attachment_id\"",
                "\"beacon_type\"",
                "\"uuid\"",
                "\"major\"",
                "\"minor\"",
                "\"check_location\""
        };
        List<String> keys = Arrays.asList(keyArray);
        List<List<String>> values = new ArrayList<List<String>>();
        String[] value0Array = new String[]{
                "null",
                "100",
                "200"
        };
        String[] value1Array = new String[]{
                "\"eUID\"",
                "\"iBcn\""
        };
        String[] value2Array = new String[]{
                "\"D9B9EC1F-3925-43D0-80A9-1E39D4CEA95C\"",
                "\"D9B9EC1F4CEA95C\"",
                "12345"
        };
        String[] value3Array = new String[]{
                "\"B9407F3025556B57FE6D\"",
                "\"asidjfiajdf\""
        };
        String[] value4Array = new String[]{
                "\"F5F8466EAFF9\"",
                "\"oidjfidjfi\""
        };
        String[] value5Array = new String[]{
                "true",
                "false",
                ""
        };
        List<String> values0 = Arrays.asList(value0Array);
        List<String> values1 = Arrays.asList(value1Array);
        List<String> values2 = Arrays.asList(value2Array);
        List<String> values3 = Arrays.asList(value3Array);
        List<String> values4 = Arrays.asList(value4Array);
        List<String> values5 = Arrays.asList(value5Array);
        values.add(values0);
        values.add(values1);
        values.add(values2);
        values.add(values3);
        values.add(values4);
        values.add(values5);
        List<String> res = mg.generateResultList(keys, values);
        for (String s: res) {
            System.out.println(s);
        }
        JSONGenerator jsonGenerator = new JSONGenerator();
        jsonGenerator.generate(res, "body");
    }
}
