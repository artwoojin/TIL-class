package org.example.week02.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1018 {

    static char[][] arr; // 입력된 체스판을 저장할 2차원 배열
    static int minChanges = Integer.MAX_VALUE; // 최소 변경 횟수를 저장할 변수

    // 주어진 좌표부터 시작하는 8x8 체스판에서 변경이 필요한 횟수를 계산하는 메서드
    static int calculateChanges(int startX, int startY) {
        int changes = 0;
        char color = 'W'; // 시작 색을 흰색으로 설정

        // 8x8 체스판을 탐색하면서 변경 횟수 계산
        for (int i = startX; i < startX + 8; i++) {
            for (int j = startY; j < startY + 8; j++) {
                if (arr[i][j] != color) { // 현재 위치의 색이 체스판일 때의 색과 다른 경우
                    changes++;
                }
                // 색을 번갈아가며 변경
                color = (color == 'W') ? 'B' : 'W';
            }
            // 행이 바뀔 때마다 시작 색 변경
            color = (color == 'W') ? 'B' : 'W';
        }
        // 흰색으로 시작하는 경우와 검정색으로 시작하는 경우 중에서 더 작은 변경 횟수 반환
        return Math.min(changes, 64 - changes);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];

        // 체스판을 입력받아서 2차원 배열 arr에 저장
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        // 모든 가능한 8x8 부분 체스판을 탐색하여 최소 변경 횟수 찾기
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                minChanges = Math.min(minChanges, calculateChanges(i, j));
            }
        }

        // 최소 변경 횟수 출력
        System.out.println(minChanges);
        br.close();
    }
}

