package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class JSONGenerator {
    public void generate(List<String> list, String envName) throws IOException {
        String s = generateString(list, envName);
        FileWriter writer = new FileWriter("/Users/mzong/Desktop/test.json");
        writer.write(s);
        writer.close();
    }

    private String generateString(List<String> list, String envName) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append("{\"").append(envName).append("\":")
                    .append(list.get(i)).append("}");
            if (i != list.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
