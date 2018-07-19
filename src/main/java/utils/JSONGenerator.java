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

    public void generate(List<String> envNames, List<List<String>> envValues) throws IOException{
        String s = generateString(envNames, envValues);
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

    private String generateString(List<String> envNames, List<List<String>> envValues) {
        //get the combination list
        List<List<String>> resultList = new ArrayList<List<String>>();
        backtracking(envValues, resultList, new ArrayList<String>(), 0);

        //parse the list into json string
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < resultList.size(); i++) {
            sb.append("{");
            List<String> currentList = resultList.get(i);
            for (int j = 0; j < currentList.size(); j++) {
                sb.append("\"").append(envNames.get(j)).append("\": ");
                sb.append(currentList.get(j));
                if (j != currentList.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("}");
            if (i != resultList.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void backtracking(List<List<String>> envValues, List<List<String>> res, List<String> currentList, int currentIndex) {
        if (currentIndex == envValues.size()) {
            res.add(new ArrayList<String>(currentList));
            return;
        }

        List<String> envList = envValues.get(currentIndex);
        for (int i = 0; i < envList.size(); i++) {
            currentList.add(envList.get(i));
            backtracking(envValues, res, currentList, currentIndex + 1);
            currentList.remove(currentList.size() - 1);
        }
    }
}
