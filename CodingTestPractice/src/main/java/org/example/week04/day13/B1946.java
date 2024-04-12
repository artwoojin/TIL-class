package org.example.week04.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1946 {
    /* 강의 예제 : 신입 사원
    *
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] rank = new int[N + 1];

            for (int j = 0; j < N; j++) {
                String[] str = br.readLine().split(" ");
                int documentRank = Integer.parseInt(str[0]);
                int interviewRank = Integer.parseInt(str[1]);

                rank[documentRank] = interviewRank;
            }

            int answer = 1;
            int standard = rank[1];

            for (int k = 2; k <= N; k++) {
                if (rank[k] < standard) {
                    answer++;
                    standard = rank[k];
                }
            }
            System.out.println(answer);
        }
    }
}
