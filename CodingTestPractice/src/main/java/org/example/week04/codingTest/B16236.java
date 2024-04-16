package org.example.week04.codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16236 {
    /*
    *
    ***** 풀이 설계 : 조건에 맞는 물고기가 최단 거리에 있는 것부터 탐색해나가므로 BFS 사용
    *     지도 정보를 2차원 배열에 저장하고, x,y 좌표값을 저장. 상하좌우로 이동할 수 있게 세팅
    *     먹을 수 있는 물고기가 있으면 그 위치, 거리를 저장
    *     가장 거리가 짧은 물고기가 여러 마리일 경우, 가장 위쪽에 있는 물고기 탐색
    *     가장 위쪽에 있는 물고기도 여러 마리일 경우, 가장 왼쪽에 있는 물고기 탐색
    *     남은 물고기가 0이거나 먹을 수 있는 물고기가 0이 될 때까지 탐색 반복
    * */

    // 공간의 크기, 상어의 x,y좌표, 크기, 물고기 수, 남은 물고기 수
    static int N, sharkX, sharkY, sharkSize, fish, alive;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {-1, 0, 0, 1};
    static int[][] map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine()); // 공간의 크기
        map = new int[N][N]; //
        alive = 0;

        // 지도 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) { // 상어 위치 저장
                    sharkX = i;
                    sharkY = j;
                    map[sharkX][sharkY] = 0; // 상어 위치를 0으로 만들어 빈 공간화함
                } else if (map[i][j] > 0) {
                    fish++;
                }
            }
        }

        while (alive != 0) {
            fish = alive;
            bfs();

            if (fish == alive) {
                break;
            }
        }
        System.out.println();
    }

    private static void bfs() {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sharkX, sharkY, 0});
        visited[sharkX][sharkY] = true;

        int nextX = -1;
        int nextY = -1;
        int count = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int point = now[2];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newY >= 0 && newX < N && newY < N && !visited[newX][newY] && map[newX][newY] <= sharkSize) {
                    visited[newX][newY] = true;
                    int newCount = point + 1;

                    if (map[newX][newY] > 0 && map[newX][newY] < sharkSize) {
                        if (nextX == -1 || nextX > newX || (nextX == newX && nextY > newY)) {
                            nextX = newX;
                            nextY = newY;
                            count = newCount;
                        }
                    }
                    queue.offer(new int[]{newX, newY, newCount});
                }
            }
        }
        if (nextX != -1) {
            map[nextX][nextY] = 0;
            alive--;
            sharkX = nextX;
            sharkY = nextY;
            fish--;
            if (fish == 0)
                alive = 0;
        }
    }
}
