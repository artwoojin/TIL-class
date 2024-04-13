package org.example.week04.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1149 {
    /*
     ***** 문제 설명 : RGB거리
     *     RGB거리에는 집이 N개 있다. 거리는 선분으로 나타내고, 1~N번 집이 순서대로 있다.
     *     집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다.
     *     각각의 색으로 칠하는 비용이 주어졌을 때, 다음 규칙을 만족하면서 모든 집을 칠하는
     *     비용의 최솟값을 구한다.
     *     1) 1번 집의 색은 2번 집의 색과 같지 않아야 한다.
     *     2) N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
     *     3) i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
     *
     ***** 입출력 : 첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 입력된다.
     *     둘째 줄~N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이
     *     1번 집부터 한 줄에 하나씩 주어진다. 0 < 집을 칠하는 비용은 ≤ 1,000 인 자연수이다.
     *     이 때, 첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.
     *
     ***** 풀이 설계 : 인접한 집들은 색이 달라야 한다.
     *     입력된 비용들 중 빨강, 초록, 파랑으로 각각 집을 칠할 때의 비용을 배열에 저장한다.
     *     그 2차원 배열의 인덱스 값이 서로 다른 색들의 누적합을 비교해서 최솟값을 찾는다.
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); // 집의 수

        // 각 집을 빨강, 초록, 파랑으로 칠하는 비용 저장할 2차원 배열
        int[][] cost = new int[N][3];

        // 각 집의 비용 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 각 집에 대해 이전 집과의 비용을 고려하여 최솟값을 누적하여 저장
        for (int i = 1; i < N; i++) {
            cost[i][0] += Math.min(cost[i - 1][1], cost[i - 1][2]); // 빨강으로 칠할 때의 최솟값
            cost[i][1] += Math.min(cost[i - 1][0], cost[i - 1][2]); // 초록으로 칠할 때의 최솟값
            cost[i][2] += Math.min(cost[i - 1][0], cost[i - 1][1]); // 파랑으로 칠할 때의 최솟값
        }

        // 모든 집을 칠하는 최소 비용 출력
        int result = Math.min(cost[N - 1][0], Math.min(cost[N - 1][1], cost[N - 1][2]));
        System.out.println(result);
    }
}
