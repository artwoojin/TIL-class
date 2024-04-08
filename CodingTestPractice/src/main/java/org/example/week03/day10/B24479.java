package org.example.week03.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B24479 {
    /*
     * 0. 문제 풀이 : N개의 정점, M개의 간선으로 된 무방향 그래프를 입력받는다.
     *    정점 번호는 1~N번, 모든 간선의 가중치는 1이다.
     *    정점 R에서 시작하여 깊이 우선 탐색으로 노드를 방문할 경우,
     *    노드의 방문 순서 출력
     * 1. 풀이 설계 : 정점의 수 N, 간선의 수 M, 시작 정점 R을 입력받고,
     *    그 다음 줄부터 시작하는 반복문으로 간선 정보인 정점 u, v를 입력받는다.
     *    그 뒤 중첩 ArrayList로 u, v의 양방향 간선을 저장한다.
     *    모든 간선(u,v) 쌍의 값은 서로 다르다.
     *    그래프의 각 정점에 연결된 간선들을 오름차순 정렬하고,
     *    시작 정점에서부터 깊이 우선 탐색을 시작해서 방문 순서를 기록하고 출력한다.
     * */
    static int N, M, cnt;
    static int[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    // 깊이 우선 탐색 메서드
    public static void dfs(int x) {
        visited[x] = cnt; // 현재 노드를 방문했음을 표시하고 방문 순서 저장
        for (int i = 0; i < graph.get(x).size(); i++) { // 현재 노드와 연결된 모든 노드를 확인
            int y = graph.get(x).get(i); // 연결된 노드를 가져옴
            if (visited[y] == 0) { // 해당 노드를 방문하지 않았다면
                cnt++; // 방문 순서를 증가시킨다.
                dfs(y); // 해당 노드를 기준으로 깊이 우선 탐색을 진행
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점의 수
        M = Integer.parseInt(st.nextToken()); // 간선의 수
        int R = Integer.parseInt(st.nextToken()); // 시작 정점

        for (int i = 0; i <= N; i++) { // 그래프 초기화
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) { // 간선 정보를 입력받아 그래프에 저장
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            // 무방향이기 때문에 양쪽으로 정보를 추가
            graph.get(u).add(v); // u에서 v로 가는 간선 추가
            graph.get(v).add(u); // v에서 u로 가는 간선 추가
        }

        for (int i = 0; i < graph.size(); i++) {
            // 그래프의 각 정점에 연결된 간선들을 오름차순 정렬
            Collections.sort(graph.get(i));
        }
        cnt = 1; // 방문 순서
        visited = new int[N + 1]; // 방문 여부를 저장하는 배열 초기화
        dfs(R); // 시작 정점에서부터 깊이 우선 탐색을 시작함
        for (int i = 1; i < visited.length; i++) {
            System.out.println(visited[i]); // 각 정점의 방문 순서 출력
        }
    }
}

