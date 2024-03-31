package org.example.week02.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 입력 체스판
        String[] input = new String[N];

        // 흰 체스판과 검은 체스판 초기화
        String[] wBoard = new String[8];
        String[] bBoard = new String[8];

        // 입력 체스판에 입력값 저장
        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }

        // 흰 체스판 생성
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                wBoard[i] = "WBWBWBWB";
            } else {
                wBoard[i] = "BWBWBWBW";
            }
        }

        // 검은 체스판 생성
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                bBoard[i] = "BWBWBWBW";
            } else {
                bBoard[i] = "WBWBWBWB";
            }
        }

        // 체스판 비교
    }
}
