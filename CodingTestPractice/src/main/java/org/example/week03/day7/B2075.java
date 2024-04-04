package org.example.week03.day7;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B2075 {
    /*
     * 1. 정수 N을 입력받음
     * 2. 다음 N개의 줄에 각 줄마다 N개의 수를 입력받음
     * 3. 전체 수를 우선순위 큐에 담음
     * 4. 우선순위가 높은 순서대로 숫자를 뽑음
     * 5. 이 중에서 N번째 큰 수를 찾음
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        // 우선순위 큐 생성(내림차순)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            // 한 줄씩 수를 입력받아서 공백 단위로 분리
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                // 각 줄마다 N개의 수를 우선순위 큐에 추가
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }
        // 우선순위 큐에서 N-1개의 수를 순서대로 제거하여 N번째로 큰 수를 찾음
        for (int i = 0; i < N - 1; i++) {
            pq.poll();
        }
        bw.write(pq.poll() + ""); // 우선순위 큐에서 가장 큰 수를 출력(문자열로 변환)
        bw.flush();
        bw.close();
    }
}