package org.example.week04.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1916 {
    /*
    ***** 문제 설명 : 최소비용 구하기
    *     N개의 도시가 있고, 한 도시에서 다른 도시로 가는 M개의 버스가 있다.
    *     A번째 도시에서 B번째 도시로 가는데 드는 버스 비용을 최소화하려고 한다.
    *     A번째 도시에서 B번째 도시로 가는데 드는 최소비용을 출력한다. 도시의 번호는 1~N 이다.
    *
    ***** 입출력 : 첫째 줄에 도시의 갯수 N(1 ≤ N ≤ 1,000)이 입력된다.
    *     둘째 줄에는 버스의 개수 M(1 ≤ M ≤ 100,000)이 입력된다.
    *     셋째 줄부터 M+2번째 줄까지 버스의 정보가 입력된다.
    *     버스의 정보는 출발 도시의 번호, 도착지의 도시 번호, 버스 비용이 빈칸으로 구분되어 입력된다.
    *     0 ≤ 버스의 비용 < 100,000 이다.
    *     그 다음 M+3번째 줄에는 우리가 구하고자 하는 출발점의 도시 번호와 도착점의 도시 번호가 입력된다.
    *     출발점에서 도착점을 갈 수 있는 경우만 입력으로 주어진다.
    *     이 때 출발 도시에서 도착 도시까지 가는데 드는 최소 비용을 출력한다.
    *
    ***** 풀이 설계 : 각 도시를 노드로, 버스를 간선으로 나타낸다.
    *     다익스트라 알고리즘으로 출발 도시에서 각 도착 도시까지의 최소 비용을 계산한다.
    *     출발점 - 도착점까지의 최소 비용을 출력한다.
    * */

    static int N, M; // 도시의 갯수, 버스의 갯수
    static int[] distance; // 각 도시까지의 최소 비용 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine()); // 도시의 갯수
        M = Integer.parseInt(br.readLine()); // 버스의 개수

        // 각 도시에서 출발하는 버스 정보를 저장하는 리스트
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) { // 각 버스의 정보 입력
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 출발 도시
            int end = Integer.parseInt(st.nextToken()); // 도착 도시
            int cost = Integer.parseInt(st.nextToken()); // 버스 비용
            // 출발 도시에서 도착 도시까지의 비용 저장
            list.get(start).add(new Node(end, cost));
        }

        distance = new int[N + 1]; // 각 도시까지의 최소 비용 저장
        Arrays.fill(distance, Integer.MAX_VALUE); // 최소 비용 배열을 최대값으로 초기화

        st = new StringTokenizer(br.readLine());
        int city1 = Integer.parseInt(st.nextToken()); // 출발 도시 번호
        int city2 = Integer.parseInt(st.nextToken()); // 도착 도시 번호

        // 우선순위 큐를 이용한 다익스트라 알고리즘
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 출발 도시에서부터의 거리 계산을 위해 우선순위 큐에 추가
        pq.add(new Node(city1, 0));
        distance[city1] = 0;

        while (!pq.isEmpty()) { // 우선순위 큐가 빌 때까지 반복
            Node node = pq.poll(); // 우선순위 큐에서 노드를 꺼내옴
            int now = node.now; // 현재 도시
            int nowCost = node.cost; // 현재 도시까지의 비용

            // 현재까지의 비용이 이미 저장된 최소 비용보다 크다면 넘어감
            if (nowCost > distance[now]) {
                continue;
            }

            // 현재 도시에서 갈 수 있는 모든 도시에 대해 반복
            for (Node next : list.get(now)) {
                // 현재 도시를 거쳐서 갈 때의 비용이 더 작다면 최소 비용 갱신
                if (distance[next.now] > next.cost + nowCost) {
                    distance[next.now] = next.cost + nowCost;
                    // 다음 도시를 우선순위 큐에 추가
                    pq.add(new Node(next.now, next.cost + nowCost));
                }
            }
        }
        System.out.println(distance[city2]); // 도착 도시까지의 최소 비용 출력
    }

    static class Node implements Comparable<Node>{
        int now, cost; // 현재 도시와 해당 도시까지의 비용

        public Node(int now, int cost) {
            this.now = now;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) { // 우선순위 큐를 위한 비교 메서드
            return this.cost - o.cost; // 비용이 작은 순으로 정렬
        }
    }
}