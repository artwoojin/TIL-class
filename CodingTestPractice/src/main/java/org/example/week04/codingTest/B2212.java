package org.example.week04.codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2212 {
    /*
     ***** 문제 설명 :
     * N개의 센서들이 있고, 이들을 K개의 구간으로 나누려고 한다.
     * 각 구간 사이의 거리를 줄이기 위해 집중국의 위치를 정해야 한다.
     * 이 때 거리의 합을 최소로 하는 경우를 찾고, 그 때의 거리 합을 출력한다.
     *
     ***** 입출력 :
     * 첫 줄에는 센서의 개수 N이 주어지고, 둘째 줄에는 집중국의 개수 K가 주어진다.
     * 셋째 줄에는 각 센서의 위치가 주어진다.
     *
     ***** 풀이 설계 :
     * 입력받은 센서의 거리를 오름차순으로 정렬해서 배열에 저장한다.
     * 각 센서 거리의 차이를 담은 배열을 만들고 정렬한다.
     * 거리 차이 배열의 합을 출력한다.
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 센서의 개수
        int K = Integer.parseInt(br.readLine()); // 집중국의 개수

        // 집중국의 개수가 센서의 개수보다 크거나 같으면 거리 합은 0
        if (K >= N) {
            System.out.println(0);
            return;
        }

        int[] coordinates = new int[N]; // 각 센서의 위치를 저장할 배열
        int sum = 0; // 거리 합

        // 센서의 위치를 입력받고 배열에 저장
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coordinates[i] = Integer.parseInt(st.nextToken());
        }
        // 센서의 위치를 오름차순으로 정렬
        Arrays.sort(coordinates);

        // 각 센서 사이의 거리 차이를 저장할 배열을 선언
        int[] difference = new int[N - 1];
        // 인접한 센서 사이의 거리 차이를 계산하고 배열에 저장
        for (int i = 0; i < N - 1; i++) {
            difference[i] = coordinates[i + 1] - coordinates[i];
        }
        // 거리 차이 배열을 오름차순으로 정렬
        Arrays.sort(difference);

        // (N-1)-(K-1)개의 구간을 선택해서 거리를 합산
        for (int i = 0; i < N - K; i++) {
            sum += difference[i];
        }

        System.out.println(sum);
    }
}

