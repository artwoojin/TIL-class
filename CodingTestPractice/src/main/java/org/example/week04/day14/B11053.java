package org.example.week04.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B11053 {
    /*
     * 강의 예제 : 가장 긴 증가하는 부분수열
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 수열의 길이
        int[] arr = new int[N]; // 수열을 저장할 배열
        // 공백을 기준으로 문자열을 나누어 배열에 저장
        String[] str = br.readLine().split(" ");

        // 문자열을 정수 배열로 변환하여 저장
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        // 각 위치에서의 최장 부분수열의 길이를 저장할 배열
        int[] memo = new int[N];
        memo[0] = 1; // 첫 번째 수는 부분수열의 길이가 1이므로 1로 초기화

        // 동적 프로그래밍을 이용하여 최장 부분수열의 길이 계산
        for (int i = 1; i < N; i++) {
            memo[i] = 1; // 기본적으로 자기 자신만으로 부분수열의 길이는 1
            for (int j = 0; j < i; j++) {
                // 현재 위치의 수가 이전 위치의 수보다 큰 경우
                if (arr[i] > arr[j]) {
                    // 현재 위치의 부분수열의 길이를 갱신
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
        }

        // 최장 부분수열의 길이 중 가장 큰 값을 찾아 출력
        int answer = Arrays.stream(memo).max().getAsInt();
        System.out.println(answer);
    }
}

