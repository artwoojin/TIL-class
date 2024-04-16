package org.example.week04.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13305 {
    /*
    ***** 문제 설명 : 주유소(https://www.acmicpc.net/problem/13305)
    *     어떤 나라에 N개의 도시가 있는데, 이 도시들은 일직선 도로 위에 있다.(수평)
    *     제일 왼쪽의 도시에서 제일 오른쪽의 도시로 자동차를 이용하여 이동하려 한다.
    *     인접한 두 도시 사이의 도로들은 서로 길이가 다를 수 있다.
    *     처음 출발할 때 자동차에는 기름이 없어서 주유소에서 기름을 넣고 출발해야 한다.
    *     기름통의 크기는 무제한이고, 자동차는 1km 마다 1리터의 기름을 사용한다.
    *     각 도시에는 주유소가 하나씩 있고, 도시마다 주유소의 리터당 가격은 다를 수 있다.
    *     각 도시에 있는 주유소의 기름 가격과 각 도시를 연결하는 도로 길이를 입력으로 받아
    *     제일 왼쪽 도시에서 제일 오른쪽 도시로 이동하는 최소 비용을 계산한다.
    *
    ***** 입출력 : 첫 번째 줄에는 도시의 개수를 나타내는 정수 N(2 ≤ N ≤ 100,000)이,
    *     다음 줄에는 인접한 두 도시를 연결하는 도로의 길이가 제일 왼쪽 도로부터 N-1개의 자연수로 입력된다.
    *     다음 줄에는 주유소의 리터당 가격이 제일 왼쪽 도시부터 순서대로 N개의 자연수로 입력된다.
    *     제일 왼쪽 도시부터 제일 오른쪽 도시까지의 거리는 1이상 1,000,000,000 이하의 자연수이다.
    *     리터당 가격은 1 이상 1,000,000,000 이하의 자연수이다.
    *     이 때, 제일 왼쪽 도시에서 제일 오른쪽 도시로 가는 최소 비용을 출력한다.
    *
    ***** 풀이 설계 : 각 도시를 순회하면서 최소 기름값을 갱신하고,
    *     각 도시간 거리를 곱해서 최소 주유비용을 구한다.
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); // 도시의 갯수
        long[] distance = new long[N - 1]; // 도시간 거리
        long[] cost = new long[N]; // 리터당 기름값

        // 도시간 거리 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }

        // 리터당 기름값 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0; // 총 비용
        long minCost = cost[0]; // 최소 기름값(첫 번째 도시의 기름값으로 초기화)

        // 각 도시를 순회하면서 최소 기름값을 찾고, 해당 가격으로 총 비용을 계산
        for (int i = 0; i < N - 1; i++) {
            // 현재 도시의 기름값이 최소 주유 비용보다 작으면 최소 주유 비용 갱신
            if (cost[i] < minCost) {
                minCost = cost[i];
            }
            sum += minCost * distance[i];
        }
        System.out.println(sum);
    }
}
