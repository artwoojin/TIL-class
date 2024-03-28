package org.example.week02.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String fileName = br.readLine();
            int lastIdx = fileName.lastIndexOf('.');
            String file = (lastIdx != -1) ? fileName.substring(0, lastIdx) : fileName;
            map.put(file, map.getOrDefault(file, 0) + 1);
        }

        StringBuilder fileCount = new StringBuilder();
        for (String s : map.keySet()) {
            fileCount.append(s).append(" ").append(map.get(s)).append("\n");
        }
        System.out.print(fileCount);
    }
}
