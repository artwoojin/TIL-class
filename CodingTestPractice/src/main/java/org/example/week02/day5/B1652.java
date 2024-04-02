package org.example.week02.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1652 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 정사각형 방의 크기를 입력받음
        int room[][] = new int[n][n]; // 방의 상태를 저장할 2차원 배열 생성
        for(int i=0; i<n; i++) {
            String s = br.readLine(); // 방 상태를 한 줄씩 입력받아 문자열 s에 저장
            for(int j=0; j<n; j++)
                room[i][j] = s.charAt(j) == '.' ? 0 : 1; // '.'이면 0(빈 공간), 'X'이면 1(벽)로 상태 저장
        }

        int horizontal = 0; // 세로로 두 개 이상 연속된 빈 칸
        int vertical = 0; // 가로로 두 개 이상 연속된 빈 칸
        for(int i=0; i<n; i++) {
            int count = 0; // 연속된 빈 칸
            for(int j=0; j<n; j++) {
                if(room[i][j] == 0) count++; // 현재 칸이 빈 칸(0)이면 count 증가
                if(room[i][j] == 1) { // 현재 칸이 벽(1)이면
                    if(count > 1) horizontal++; // count가 1보다 크면 세로로 두 개 이상의 연속된 빈 칸이므로 vertical 증가
                    count = 0;
                }
                if(j == n-1 && count > 1) horizontal++; // 한 줄이 끝날 때, 빈 칸이 두 개 이상 연속된 경우 처리
            }
        }

        for(int i=0; i<n; i++) {
            int count = 0;
            for(int j=0; j<n; j++) {
                if(room[j][i] == 0) count++; // 현재 칸이 빈 칸(0)이면 count 증가
                if(room[j][i] == 1) { // 현재 칸이 벽(1)이면
                    if(count > 1) vertical++; // count가 1보다 크면 가로로 두 개 이상의 연속된 빈 칸이므로 horizontal 증가
                    count = 0;
                }
                if(j == n-1 && count > 1) vertical++; // 한 줄이 끝날 때, 빈 칸이 두 개 이상 연속된 경우 처리
            }
        }

        System.out.println(horizontal + " " + vertical);
    }
}

