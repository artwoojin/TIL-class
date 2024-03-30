package org.example.week02.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] alphabet = new int[26];

        for (char ch : s.toCharArray()) {
            alphabet[ch - 'A']++;
        }

        int oddNum = 0, center = 0;
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] % 2 == 1) {
                center = i;
                oddNum ++;
            }
        }

        StringBuilder sb = new StringBuilder();
        if ((s.length() % 2 == 1 && oddNum > 1) || (s.length() % 2 == 0 && oddNum > 0)) {
            sb.append("I'm Sorry Hansoo");
        } else {
            StringBuilder head = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < alphabet[i] / 2; j++) {
                    head.append((char)(i + 'A'));
                }
            }
            String tail = new StringBuilder(head).reverse().toString();
            if (oddNum == 1) {
                head.append((char)(center + 'A'));
            }
            sb.append(head).append(tail);
        }
        System.out.println(sb);
    }
}
