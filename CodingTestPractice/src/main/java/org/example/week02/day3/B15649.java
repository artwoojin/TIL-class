package org.example.week02.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15649 {
    static int N,M;
    static int[] arr; // 수열 저장 배열
    static boolean[] check; // 방문 여부 확인 배열
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        check = new boolean[N];

        finding(0);
        br.close();
        System.out.println(sb);
    }

    static void finding(int index) {
        if (index == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!check[i]) {
                check[i] = true; // 자식 노드 방문 시에 자기 자신을 빼야하므로 true
                arr[index] = i + 1 ; // i=0부터 시작하지만 1~N 까지 숫자가 들어가기 때문
                finding(index + 1); // 자식 노드 방문
                check[i] = false; // 자식 노드 방문 후 방문 기록 지움
            }
        }
    }
}

// 틀렸다고 함!