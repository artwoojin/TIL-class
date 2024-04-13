package org.example.week04.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B11722 {
    /*
     ***** 문제 설명 : 가장 긴 감소하는 부분 수열
     *     수열 A가 주어졌을 때, 가장 긴 감소하는 부분 수열의 길이를 구한다.
     *
     ***** 입출력 : 첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.
     *     둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)
     *     이 때, 첫째 줄에 수열 A의 가장 긴 감소하는 부분 수열의 길이를 출력한다.
     *
     ***** 풀이 설계 : 가장 긴 감소하는 부분 수열의 길이를 저장할 배열을 만든다.
     *     수열이 저장된 배열을 돌면서 부분 수열을 만든다.
     *     현재 위치의 수가 이전 위치의 수보다 작은 경우,
     *     현재 위치의 부분 수열의 길이를 갱신한다.
     *     이 때 감소하는 부분 수열의 길이 배열에서 가장 큰 값을 찾아 출력한다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 수열의 길이
        int[] arr = new int[N]; // 수열을 저장할 배열
        String[] str = br.readLine().split(" ");

        // 문자열을 정수 배열로 변환 저장
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        // 각 위치에서 가장 긴 감소하는 부분 수열의 길이를 저장할 배열
        int[] memo = new int[N];
        memo[0] = 1; // 첫 번째 수는 부분 수열의 길이가 1이므로 1로 초기화

         // 동적 프로그래밍을 이용하여 가장 긴 감소하는 부분 수열의 길이 계산
        for (int i = 1; i < N; i++) {
            memo[i] = 1;
            for (int j = 0; j < i; j++) {
                // 현재 위치의 수가 이전 위치의 수보다 작은 경우
                if (arr[i] < arr[j]) {
                    // 현재 위치의 부분 수열의 길이를 갱신
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
        }

        // 감소하는 부분 수열의 길이 중 가장 큰 값을 찾아 출력
        int answer = Arrays.stream(memo).max().getAsInt();
        System.out.println(answer);
    }
}
