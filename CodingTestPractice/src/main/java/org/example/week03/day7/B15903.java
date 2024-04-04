package org.example.week03.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B15903 {
    /*
    * 1. 카드의 갯수 n, 카드 합체의 횟수 m을 입력받음
    * 2. n개의 자연수 배열을 입력받음(각 수는 공백으로 구분)
    * 3. 카드의 값들을 우선순위 큐에 저장(오름차순 자동정렬)
    * 4. 가장 작은 값의 카드들을 m번 합침
    * 5. 이후 카드들의 값 합계를 출력
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 카드의 갯수
        int m = Integer.parseInt(st.nextToken()); // 카드 합체의 횟수

        // 우선순위 큐에 카드 값을 저장(오름차순 자동정렬)
        PriorityQueue<Long> pq = new PriorityQueue<>();

        // 카드 값들을 입력받아 우선순위 큐에 저장
        // 각 토큰(카드 값)을 Long 타입으로 변환하여 우선순위 큐에 추가
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        // 가장 작은 값의 카드 두 장을 꺼내서 합친 후 다시 큐에 넣음
        for (int i = 0; i < m; i++) {
            long newCard = pq.poll() + pq.poll();
            pq.add(newCard);
            pq.add(newCard);
        }

        long sum = 0;
        // 우선순위 큐에 있는 모든 카드 값을 더함
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        // 카드 값의 총 합계 출력
        System.out.println(sum);
    }
}
