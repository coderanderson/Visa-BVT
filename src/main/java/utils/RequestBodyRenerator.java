package utils;

import java.util.*;

public class RequestBodyRenerator {
    public List<String> generateResultList(List<String> keys, List<List<String>> values) {
        List<String> res = new ArrayList<String>();

        createExpected(keys, values, res);

        for (int i = 0; i < keys.size(); i++) {
            backtracking(keys, values, res, i, 0, new StringBuilder("\"{"));
        }

        return res;
    }

    private void backtracking(List<String> keys, List<List<String>> values, List<String> res,
                              int expectedIndex, int current, StringBuilder sb) {
        if (current == keys.size()) {
            String temp = sb.append("}\"").toString();
            res.add(temp.substring(0, 2) + temp.substring(4, temp.length()));
            return;
        }

        String currentKey = keys.get(current);
        sb.append(", ").append(currentKey.replace("\"", "\\\"")).append(": ");

        List<String> currentValues = values.get(current);

        if (expectedIndex == current) {
            for (int i = 1; i < currentValues.size(); i++) {
                String newValue = currentValues.get(i).replace("\"", "\\\"");
                int currentLength = sb.length();
                sb.append(newValue);
                backtracking(keys, values, res, expectedIndex, current + 1, sb);
                sb.delete(currentLength, sb.length());
            }
        } else {
            String newValue = currentValues.get(0).replace("\"", "\\\"");
            sb.append(newValue);
            backtracking(keys, values, res, expectedIndex, current + 1, sb);
        }
    }

    private void createExpected(List<String> keys, List<List<String>> values, List<String> res) {
        StringBuilder sb = new StringBuilder();
        sb.append("\"{");
        for(int i = 0; i < keys.size(); i++) {
            String currentKey = keys.get(i);
            sb.append(currentKey.replace("\"", "\\\"")).append(": ");
            String currentValue = values.get(i).get(0).replace("\"", "\\\"");
            sb.append(currentValue);
            if (i != keys.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("}\"");
        res.add(sb.toString());
    }
}
