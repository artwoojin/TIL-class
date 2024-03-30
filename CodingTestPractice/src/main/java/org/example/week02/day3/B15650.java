package org.example.week02.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15650 {
    static int N, M;
    static int[] selected;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selected = new int[M];
        visited = new boolean[N + 1];

        backtracking(1, 0);
    }

    static void backtracking(int start, int count) {
        if (count == M) {
            for (int num : selected) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[count] = i;
                backtracking(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }
}
