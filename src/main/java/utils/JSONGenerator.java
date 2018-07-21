package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class JSONGenerator {

    public void generate(List<String> envNames, List<List<String>> envValues, String outputPath) throws IOException{
        String s = generateString(envNames, envValues);
        FileWriter writer = new FileWriter(outputPath);
        System.out.println(s);
        writer.write(s);
        writer.close();
    }

    private String generateString(List<String> envNames, List<List<String>> envValues) {

        //get the combination list
        List<List<String>> resultList = new ArrayList<List<String>>();

        //add expected list
        addExpectedList(envValues, resultList);

        //add combination list
        for (int i = 0; i < envNames.size(); i++) {
            backtracking(envValues, resultList, new ArrayList<String>(), 0, i);
        }

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

    private void backtracking(List<List<String>> envValues, List<List<String>> res, List<String> currentList,
                              int currentIndex, int expectedIndex) {
        if (currentIndex == envValues.size()) {
            res.add(new ArrayList<String>(currentList));
            return;
        }

        List<String> envList = envValues.get(currentIndex);
        if(currentIndex == expectedIndex) {
            for (int i = 1; i < envList.size(); i++) {
                currentList.add(envList.get(i));
                backtracking(envValues, res, currentList, currentIndex + 1, expectedIndex);
                currentList.remove(currentList.size() - 1);
            }
        } else {
            currentList.add(envList.get(0));
            backtracking(envValues, res, currentList, currentIndex + 1, expectedIndex);
            currentList.remove(currentList.size() - 1);
        }
    }

    private void addExpectedList(List<List<String>> envValues, List<List<String>> res) {
        List<String> expectedList = new ArrayList<String>();
        for (int i = 0; i < envValues.size(); i++) {
            expectedList.add(envValues.get(i).get(0));
        }
        res.add(expectedList);
    }
}
