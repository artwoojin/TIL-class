package org.example.week03.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B24444 {
    /*
     * 0. 문제 설명 : N개의 정점과 M개의 간선으로 구성된 무방향 그래프가 주어진다.
     *    정점 번호는 1~N번이고, 모든 간선의 가중치는 1이다.
     *    정점 R에서 시작하여 너비 우선 탐색으로 노드를 방문할 경우의 방문 순서를 출력한다.
     *    인접 정점은 오름차순으로 방문한다.
     * 1. 풀이 설계 : 첫째 줄에 정점의 수 N, 간선의 수 M, 시작 정점 R을 입력받는다.
     *    다음 M개 줄에 간선 정보인 정점 u, v를 입력받는다.(가중치 1인 양방향 간선을 나타냄)
     *    이때 모든 간선의 (u,v) 쌍의 값은 서로 다르다.
     *    그래프의 각 정점에 연결된 간선들을 오름차순 정렬하고,
     *    시작 정점에서부터 너비 우선 탐색을 시작해서 방문 순서를 기록하고 출력한다.
     *    첫째 줄부터 N개의 줄에 정수를 한 개씩 출력하는데 i번째 줄에는 정점 i의 방문순서를 출력한다.
     *    시작 정점의 방문 순서는 1이다. 시작 정점에서 방문할 수 없는 경우 0을 출력한다.
     * */
    static int N, M;
    static int[] visited; // 각 정점의 방문 순서를 저장하는 배열
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 그래프를 인접 리스트로 표현

    // 너비 우선 탐색(BFS) 메서드
    public static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 1; // 방문 순서를 나타내는 변수, 시작 정점의 방문 순서를 1로 설정
        queue.add(x); // 시작 정점을 큐에 추가
        visited[x] = cnt++;

        while (!queue.isEmpty()) {
            int size = queue.size(); // 현재 큐의 크기만큼만 반복하여 같은 층위의 정점들을 처리
            for (int i = 0; i < size; i++) {
                int y = queue.poll(); // 큐에서 정점을 꺼냄
                Collections.sort(graph.get(y)); // 해당 정점과 연결된 정점들을 오름차순으로 정렬
                for (int z : graph.get(y)) { // 해당 정점과 연결된 정점들에 대해 반복
                    if (visited[z] == 0) { // 방문하지 않은 정점인 경우
                        visited[z] = cnt++; // 방문 순서를 기록하고
                        queue.add(z); // 큐에 추가하여 다음에 방문할 수 있도록 함
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점의 수
        M = Integer.parseInt(st.nextToken()); // 간선의 수
        int R = Integer.parseInt(st.nextToken()); // 시작 정점

        visited = new int[N + 1]; // 각 정점의 방문 순서를 저장할 배열
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>()); // 그래프를 인접 리스트로 초기화
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v); // 양방향 간선이므로 u에서 v로의 간선 추가
            graph.get(v).add(u); // v에서 u로의 간선 추가
        }

        // 각 정점에 연결된 간선들을 오름차순으로 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        // 시작 정점부터 너비 우선 탐색 수행
        bfs(R);

        // 각 정점의 방문 순서 출력
        for (int i = 1; i <= N; i++) {
            System.out.println(visited[i]);
        }
    }
}
