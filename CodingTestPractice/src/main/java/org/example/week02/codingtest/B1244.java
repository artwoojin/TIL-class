package org.example.week02.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int switches = Integer.parseInt(st.nextToken());
        int[] status = new int[switches + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= switches; i++) {
            status[i] = Integer.parseInt(st.nextToken());
        }

        int students = Integer.parseInt(br.readLine());
        for (int i = 0; i < students; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                for (int j = number; j <= switches; j += number) {
                    status[j] = 1 - status[j];
                }
            } else {
                int left = number - 1;
                int right = number + 1;
                while (left > 0 && right <= switches && status[left] == status[right]) {
                    left--;
                    right++;
                }
                for (int j = left + 1; j < right; j++) {
                    status[j] = 1 - status[j];
                }
            }
        }

        for (int i = 1; i <= switches; i++) {
            sb.append(status[i]).append(" ");
            if (i % 20 == 0 || i == switches) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}


