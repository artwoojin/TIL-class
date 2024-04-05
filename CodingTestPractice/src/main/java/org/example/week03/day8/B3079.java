package org.example.week03.day8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3079 {
    /*
     * 0. 문제 설명 : 상근이와 친구들이 입국심사를 기다리고 있는데, 어떻게 심사를 받으면
     *    모든 사람이 심사를 받는데 걸리는 시간이 최소가 될지 궁금해졌다.
     *    각 심사관이 심사를 하는 데 소요되는 시간은 모두 다르다.
     * 1. 입국 심사대 갯수 N, 사람 수 M 입력받음
     * 2. 다음 N개 줄에 각 심사대 심사 소요 시간 timeArr 배열 입력 받음
     * 3. 심사 소요 시간의 최대값은 timeArr 배열 중 가장 큰 값 max * 사람 수 M이므로
     *    그 값을 end로 두고, 중간 값 mid를 구해서 이진 탐색 시작
     * 4. 각 심사대에서 처리 가능한 사람 수 합산 sum과 M을 비교하여 최적값 탐색
     * 5. 최적값 = 심사 소요 시간의 최솟값인 result 출력
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 입국 심사대 갯수
        long M = Long.parseLong(st.nextToken()); // 사람 수

        long[] timeArr = new long[N]; // 각 심사대의 소요 시간 저장
        long max = 0; // 가장 오래 걸리는 심사 시간
        // N개의 줄에 각 심사대의 소요 시간 입력 받음
        for (int i = 0; i < N; i++) {
            timeArr[i] = Long.parseLong(br.readLine());
            // 각 심사 소요 시간 배열 중 가장 오래 걸리는 시간 갱신
            max = Math.max(max, timeArr[i]);
        }

        long start = 0;
        // 총 심사 소요 시간의 최대값 = 가장 오래 걸리는 심사 소요 시간 * 사람 수로 초기화
        long end = max * M;
        long result = Long.MAX_VALUE;// 총 심사 소요 시간의 최솟값

        while (start <= end) {
            // 중간 값(mid) 계산
            long mid = (start + end) / 2;
            long sum = 0; // mid 시간 동안 각 심사대에서 처리 가능한 사람 수의 합

            for (int i = 0; i < N; i++) {
                // mid 시간 동안 각 심사대에서 처리 가능한 사람 수
                long count = mid / timeArr[i];
                // 사람 수를 초과하면 반복 종료
                if (sum >= M) break;
                // sum에 현재 심사대에서 처리할 수 있는 사람 수 추가
                else sum += count;
            }

            // 처리 가능한 사람 수가 M 이상이면 총 심사 시간 값을 감소시킴
            if (sum >= M) {
                end = mid - 1;
                // result 갱신
                result = Math.min(result, mid);
            } else { // 처리 가능한 사람 수가 M 미만이면 총 심사 시간 값을 증가시킴
                start = mid + 1;
            }
        }
        System.out.println(result);
    }
}
