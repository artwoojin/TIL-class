package org.example.week04.codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9465 {
    /*
    ***** 문제 설명 : 스티커
    *
    *
    *
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 갯수

        for (int i = 0; i < T; i++) { // 각 테스트 케이스에 대해 반복
            int n = Integer.parseInt(br.readLine()); // 스티커의 갯수

            int[][] scores = new int[2][n]; // 스티커의 점수를 저장할 배열
            int[][] dp = new int[2][n]; // DP를 위한 배열

            // 첫 번째 행의 스티커 점수를 저장
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                scores[0][j] = Integer.parseInt(st.nextToken());
            }

            // 두 번째 행의 스티커 점수를 저장
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                scores[1][j] = Integer.parseInt(st.nextToken());
            }

            // 첫 번째 열에 대한 초기값 설정
            dp[0][0] = scores[0][0];
            dp[1][0] = scores[1][0];

            int maxScore = Math.max(dp[0][0], dp[1][0]); // 최대 점수 초기값 설정
            for (int j = 1; j < n; j++) { // 두 번째 열부터 마지막 열까지 반복
                if (j == 1) { // 두 번째 열일 때
                    // 이전 행과 현재 행의 두 번째 열 스티커 점수를 더한 값을 저장
                    dp[0][j] = dp[1][0] + scores[0][1];
                    dp[1][j] = dp[0][0] + scores[1][1];
                    maxScore = Math.max(dp[0][j], dp[1][j]); // 최대 점수 갱신
                    continue;
                } else { // 두 번째 열이 아닐 때
                    // 이전 행과 두 행 전의 값 중 큰 값을 선택해서 현재 행의 값과 더함
                    dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + scores[0][j];
                    dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + scores[1][j];
                    maxScore = Math.max(maxScore, Math.max(dp[0][j], dp[1][j])); // 최대 점수 갱신
                }
            }
            System.out.println(maxScore);
        }
    }
}