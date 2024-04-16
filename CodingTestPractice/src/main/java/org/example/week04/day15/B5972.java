package org.example.week04.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B5972 {
    /* 미완성 코드입니다.
    ***** 문제 설명 : 택배 배송(https://www.acmicpc.net/problem/5972)
    *     농부 현서는 농부 찬홍이에게 택배 배달을 해줘야 하고, 지금 갈 준비를 하고있다.
    *     가는 길에 만나는 모든 소들에게 여물을 줘야 하는데, 현서는 최소한의 소들을 만나고 싶다.
    *     농부 현서에게는 지도가 있다. N (1 <= N <= 50,000) 개의 헛간과,
    *     소들의 길인 M (1 <= M <= 50,000) 개의 양방향 길이 그려져 있고,
    *     각각의 길에는 C_i (0 <= C_i <= 1,000) 마리의 소가 있다.
    *     소들의 길은 두 개의 떨어진 헛간인 A_i 와 B_i (1 <= A_i <= N; 1 <= B_i <= N;
    *     A_i != B_i)를 잇는다. 두 개의 헛간은 하나 이상의 길로 연결되어 있을 수도 있다.
    *     농부 현서는 헛간 1에 있고 농부 찬홍이는 헛간 N에 있다.
    *     지도가 주어지고, 지나가는 길에 소를 만나면 줘야할 여물의 비용이 주어질 때
    *     최소 여물은 얼마인지 구한다. 이 때 가는 길의 길이는 고려하지 않는다.
    *
    ***** 입출력 : 첫째 줄에 N, M이 공백을 사이에 두고 입력된다.
    *     둘째 줄부터 M+1번째 줄까지 세 개의 정수 A_i, B_i, C_i가 입력된다.
    *     이 때 첫째 줄에 농부 현서가 가져가야 될 최소 여물을 출력한다.
    *
    ***** 풀이 설계 :
    * */

    public static int N, M;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static int[] dist = new int[50001];
    public static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];

        for(int i=0;i<=N;i++) {
            graph.add(new ArrayList<>());
        }

        // Todo
    }

    class Node implements Comparable<Node> {
        int nodeB;
        int distance;

        public Node(int nodeB, int distance) {
            this.nodeB = nodeB;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            //Todo
            return 0;
        }
    }
}
