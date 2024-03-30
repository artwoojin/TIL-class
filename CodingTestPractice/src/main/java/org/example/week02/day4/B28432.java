package org.example.week02.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class B28432 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        char before = '0';
        char after = '0';
        boolean Q_before = false;
        boolean Q_after = false;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.equals("?")) {
                Q_before = true;
            } else {
                set.add(str);
                if (Q_before && !Q_after) {
                    after = str.charAt(0);
                    Q_after = true;
                }
            }
            if (!Q_before) {
                before = str.charAt(str.length() - 1);
            }
        }

        String result = "";
        int M = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(br.readLine());
        } else {
            for (int i = 0; i < M; i++) {
                String str = br.readLine();
                if ((before == '0' || before == str.charAt(0))
                        && (after == '0' || after == str.charAt(str.length() - 1))
                        && !set.contains(str)) {
                    result = str;
                }
            }
        }
        System.out.println(result);
    }
}
