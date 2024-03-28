package org.example.week02.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            char result = str.charAt(i);
            map.put(result, map.getOrDefault(result, 0) + 1);
            max = Math.max(max, map.get(result));
        }

// 미완성!!!!!
    }
}
