package org.example.week04.day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17086 {
    /*
    ***** 문제 설명 : NxM 크기의 공간에 아기상어 여러 마리가 있다.
    *     공간은 1x1 크기의 정사각형 칸으로 나눠져 있고, 한 칸에는 아기상어가 최대 1마리 존재한다.
    *     어떤 칸의 안전 거리는 그 칸과 가장 거리가 가까운 아기 상어와의 거리이다.
    *     두 칸의 거리는 하나의 칸에서 다른 칸으로 가기 위해 지나야 하는 칸의 수이고,
    *     이동은 인접한 8방향(대각선 포함)이 가능하다. 이 때 안전거리가 가장 큰 칸을 구한다.
    *
    ***** 입출력 : 첫째 줄에 공간의 크기 N과 M(2 ≤ N, M ≤ 50)이 입력된다.
    *     둘째 줄부터 N개의 줄에 공간의 상태가 입력된다.(0은 빈 칸, 1은 아기상어 있음)
    *     빈 칸과 상어의 수가 각각 한 개 이상인 입력만 주어진다.
    *     이 때 첫째 줄에 안전 거리의 최댓값을 출력한다.
    *
    ***** 풀이 설계 : <상어 위치를 전부 queue에 넣고 BFS로 최댓값을 탐색한다.>
    *     방문 여부는 boolean 배열인 visited에 저장한다.
    *     입력값을 받을 때, 공간의 상태를 확인한다.
    *     만약 상어의 위치인 경우 큐에 추가하고, 해당 위치를 방문했음을 표시한다.
    *     BFS로 모든 빈 칸에 대해 상어로부터의 최단 거리를 계산하고, 그 중 최댓값을 출력한다.
    * */

    static int N, M; // 공간의 세로, 가로 크기
    static int[][] map; // 공간 정보 저장
    static boolean[][] visited; // 방문 여부 저장
    // 8방향의 x,y 좌표 이동
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static Queue<int[]> q = new LinkedList<>(); // BFS를 위한 큐

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        map = new int[N][M]; // 공간 정보를 저장할 배열
        visited = new boolean[N][M]; // 방문 여부를 저장할 배열

        // 공간 정보를 입력받음
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) { // 상어가 있는 위치라면
                    q.add(new int[]{i, j}); // 큐에 상어의 위치를 추가
                    visited[i][j] = true; // 상어의 위치를 방문 처리
                }
            }
        }
        System.out.println(bfs());
    }

    static int bfs() {
        int maxDistance = 0; // 안전 거리 최댓값
        while (!q.isEmpty()) { // 큐가 빌 때까지 반복
            int[] now = q.poll(); // 큐에서 현재 위치를 꺼냄
            int x = now[0]; // 현재 위치의 x 좌표
            int y = now[1]; // 현재 위치의 y 좌표

            for (int i = 0; i < 8; i++) { // 8개 방향에 대해 반복
                int nextX = x + dx[i]; // 다음 위치의 x 좌표 계산
                int nextY = y + dy[i]; // 다음 위치의 y 좌표 계산

                // 다음 위치가 공간을 벗어나지 않고 방문한 적이 없는 빈 칸일 경우
                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true; // 다음 위치 방문 처리
                    map[nextX][nextY] = map[x][y] + 1; // 한 칸씩 이동할 때마다 거리를 1씩 증가시킴
                    maxDistance = Math.max(maxDistance, map[nextX][nextY]); // 최댓값 갱신
                    q.add(new int[]{nextX, nextY}); // 다음 위치를 새로운 배열 형태로 큐에 추가
                }
            }
        }
        return maxDistance - 1; // 초기 상어 위치에서부터의 거리는 0으로 시작하므로 1을 빼줌
    }
}