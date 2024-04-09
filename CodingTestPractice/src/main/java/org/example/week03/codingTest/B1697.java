package org.example.week03.codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697 {
    /*
    ***** 문제 설명 : 수빈이는 동생과 숨바꼭질을 하고 있다.
    *     수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
    *     수빈이는 걷거나 순간이동을 할 수 있는데, 수빈이의 위치가 X일때
    *     걸으면 1초 후에 X-1 또는 X+1로 이동한다.
    *     순간이동을 하면 1초 후에 2*X의 위치로 이동하게 된다.
    *     수빈과 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간을 구한다.
    ***** 풀이 설계 :
    *     1. 너비 탐색으로 최소 소요 시간을 구한다. 현재 위치를 큐에 넣는다.
    *     2. 큐에서 현재 위치를 뽑아서 이동하고(3가지 경우), 이동한 곳의 위치를 큐에 넣는다.
    *     3. 2번을 반복한 후 N == K일 때 반복문을 탈출하고 너비 탐색을 마친다.
    *     4. 이 때의 총 이동 횟수를 출력한다.
    * */
    static int N, K, cnt;
    static int[] visited; // 방문 여부를 표시하기 위한 배열

    // 너비 우선 탐색(BFS) 메서드
    static void bfs(int now) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(now);
        visited[now] = 1; // 현재 수빈의 위치에 방문 표시

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            now = queue.poll(); // 큐에서 현재 위치를 꺼냄

            // 다음 위치 계산
            int forward = now + 1;
            int backward = now - 1;
            int teleport = now * 2;

            // 동생의 위치를 찾았을 때
            if (now == K) {
                cnt = visited[now] - 1; // 동생의 위치까지의 이동 횟수를 저장
                return; // 메소드 종료
            }

            // 다음 위치로 이동하고 방문 여부를 확인하여 큐에 추가
            if (forward <= 100_000 && visited[forward] == 0) {
                visited[forward] = visited[now] + 1; // 이동한 위치까지의 이동 횟수를 저장
                queue.add(forward); // 큐에 추가
            }
            if (backward >= 0 && visited[backward] == 0) {
                visited[backward] = visited[now] + 1; // 이동한 위치까지의 이동 횟수를 저장
                queue.add(backward); // 큐에 추가
            }
            if (teleport <= 100_000 && visited[teleport] == 0) {
                visited[teleport] = visited[now] + 1; // 이동한 위치까지의 이동 횟수를 저장
                queue.add(teleport); // 큐에 추가
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 수빈의 위치
        K = Integer.parseInt(st.nextToken()); // 동생의 위치

        visited = new int[100_001];

        // 수빈이와 동생의 위치가 같은 경우
        if (N == K) {
            System.out.println(0); // 이동할 필요 없음
        } else {
            bfs(N); // BFS 탐색 수행
            System.out.println(cnt); // 최소 이동 횟수 출력
        }
    }
}
