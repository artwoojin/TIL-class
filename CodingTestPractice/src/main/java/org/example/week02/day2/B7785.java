package org.example.week02.day2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(str.nextToken());

        HashSet<String> people = new HashSet<>();

        for (int i = 0; i < n; i++) {
            str = new StringTokenizer(br.readLine());
            String name = str.nextToken();
            String log = str.nextToken();

            if (log.equals("enter")) {
                people.add(name);
            } else if (log.equals("leave")) {
                people.remove(name);
            }

        }
        br.close();

        ArrayList<String> list = new ArrayList<String>(people);
        Collections.sort(list);

        for (int i = list.size()-1; i >=0; i--) {
            bw.write(list.get(i) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
