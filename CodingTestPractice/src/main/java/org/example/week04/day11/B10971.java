package org.example.week04.day11;

import java.io.*;
import java.util.StringTokenizer;

public class B10971 {
    /*
     ***** 문제 설명 : 1번~N번까지 번호가 매겨져 있는 도시가 있고, 도시들 사이에는 길이 있다.(없는 경우도 있음)
     *     한 외판원이 어느 한 도시에서 출발해 N개의 도시를 모두 거쳐 다시 원래의 도시로 돌아오는 여행을 계획한다.
     *     한 번 갔던 도시로는 다시 갈 수 없다.(출발했던 원래 도시로 돌아오는 경우는 제외)
     *     각 도시간 이동 소요 비용은 행렬 W[i][j]형태로 주어진다. 이는 도시 i에서 j로 가는 비용이다.
     *     i->j 비용과 j->i 비용은 다를 수 있다. 모든 도시간의 비용은 양의 정수이며, W[i][i]는 항상 0이다.
     *     도시 i에서 j로 갈 수 없는 경우도 있는데 이럴 때는 W[i][j] = 0 이라고 한다.
     *     N과 비용 행렬이 주어졌을 때, 가장 적은 비용을 들이는 외판원의 순회 여행 경로를 구한다.
     ***** 입출력 : 첫째 줄에 도시의 수 N(2 ≤ N ≤ 10), 다음 N개의 줄에는 비용 행렬을 입력받는다.
     *     각 행렬의 성분은 1,000,000 이하의 양의 정수이며, 갈 수 없는 경우는 0이 주어진다.
     *     W[i][j]는 도시 i에서 j로 가기 위한 비용을 나타낸다. 항상 순회할 수 있는 경우만 입력된다.
     *     이 때, 첫째 줄에 외판원의 순회에 필요한 최소 비용을 출력한다.
     ***** 풀이 설계 : 모든 도시를 방문하는 최소 비용을 구하는 것이므로 dfs로 탐색한다.
     *     방문 여부를 체크해서 두 번 방문하는 경우는 없도록 한다.
     *     비용이 0일 경우는 같은 도시이거나 길이 없는 경우이기 때문에, 이 경우는 제외한다.
     *     모든 도시를 방문했고 마지막 도시에서 처음 시작한 도시로 가는 길이 있으면 비용을 비교한다.
     *     이 과정을 통해 비용의 최솟값을 구한다.
     * */

    static int N, result; // 도시의 수와 최종 결과값을 저장할 변수
    static int[][] route; // 각 도시 간의 이동 비용을 저장할 배열
    static boolean[] visited; // 방문 여부를 저장할 배열

    // 깊이 우선 탐색
    public static void dfs(int start, int now, int sum, int visitedCount) {
        // 모든 도시를 방문한 경우
        if (visitedCount == N) {
            // 시작 도시로 되돌아갈 수 있는 경우만 고려
            if (route[now][start] != 0) {
                // 시작 도시까지의 이동 비용을 더해줌
                sum += route[now][start];
                // 현재까지의 최소 비용과 비교하여 더 작은 값으로 갱신
                result = Math.min(result, sum);
            }
            return;
        }

        // 현재 도시에서 이동할 수 있는 다음 도시를 탐색
        for (int i = 0; i < N; i++) {
            // 아직 방문하지 않았고, 현재 도시에서 다음 도시로 이동할 수 있는 경우
            if (!visited[i] && route[now][i] != 0) {
                // 방문 체크
                visited[i] = true;
                // 다음 도시로 이동하여 재귀 호출
                dfs(start, i, sum + route[now][i], visitedCount + 1);
                // 백트래킹: 방문 여부 되돌리기
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 도시의 수 입력
        StringTokenizer st;

        route = new int[N][N]; // 비용 행렬 초기화
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                route[i][j] = Integer.parseInt(st.nextToken()); // 비용 입력
            }
        }

        result = Integer.MAX_VALUE; // 결과값 초기화
        for (int i = 0; i < N; i++) {
            visited = new boolean[N]; // 방문 여부 배열 초기화
            visited[i] = true; // 시작 도시 방문 표시
            // 현재 위치, 현재까지의 비용, 방문한 도시 수를 전달하여 탐색 시작
            dfs(i, i, 0, 1);
        }
        System.out.println(result); // 최소 비용 출력
    }
}
