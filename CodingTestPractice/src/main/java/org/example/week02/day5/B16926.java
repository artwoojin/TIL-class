package org.example.week02.day5;

import java.io.*;
import java.util.StringTokenizer;

public class B16926 {
    static int N, M, R;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());  // 행 개수
        M = Integer.parseInt(st.nextToken());  // 열 개수
        R = Integer.parseInt(st.nextToken());  // 회전 횟수
        int space = Math.min(N, M)/2; // 회전할 공간 크기 계산
        arr = new int[N][M]; // 입력받은 배열 초기화
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // R번 회전
        for (int i = 0; i < R; i++) {
            spin(space);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bw.write(arr[i][j] + " "); // 회전한 배열 값 저장
            }
            bw.newLine();
        }
        br.close();
        bw.flush();
        bw.close();
    }

    static void spin(int space) {
        int[][] tempArr = new int[N][M]; // 회전하는 배열 값 저장하는 임시 배열
        for(int i = 0; i < space; i++) {
            for(int j = i; j< N -1 -i; j++) // 아래쪽 방향 회전
                tempArr[j+1][i] = arr[j][i];
            for(int j = i; j < M -1 -i; j++) // 오른쪽 방향 회전
                tempArr[N -1 -i][j + 1] = arr[N -1 -i][j];
            for(int j= N -1 -i; j > 0 +i; j--)	// 위쪽 방향 회전
                tempArr[j -1][M -1 -i] = arr[j][M -1 -i];
            for(int j=M -1 -i; j > 0 +i; j--)	// 왼쪽 방향 회전
                tempArr[i][j -1] = arr[i][j];
        }
        arr = tempArr;
        return;
    }
}
