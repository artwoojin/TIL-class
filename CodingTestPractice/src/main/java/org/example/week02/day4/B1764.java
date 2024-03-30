package org.example.week02.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> people = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            people.put(name, 1);
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            people.put(name, people.getOrDefault(name, 0) + 1);
            if (people.get(name) == 2) {
                list.add(name);
            }
        }

        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for (String s : list) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
