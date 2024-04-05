package org.example.week03.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11399 {
    /*
    * 0. 문제 설명 : 1대뿐인 ATM 앞에 N명의 사람들이 줄을 섰을 때,
    *    전체 사람들이 기다리는 시간의 합의 최솟값을 구한다.
    * 1. 사람의 수 N, 각자가 돈을 인출하는데 걸리는 시간의 배열 P 입력받음
    * 2. 각 사람이 돈을 인출하는 데 필요한 시간 합의 최솟값을 구해야 하므로
    * 3. P 배열의 각 요소들을 오름차순으로 정렬 후
    * 4. 반복문을 통해 순서대로 시간 누적 후 시간 합을 도출
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 사람의 수

        int[] P = new int[N]; // 각자가 돈을 인출하는데 걸리는 시간
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(P); // 오름차순 정렬

        int sum = 0; // 인출 시간의 합
        int totalSum = 0; // 인출 시간의 누적합
        for (int i = 0; i < N; i++) {
            sum += P[i];
            totalSum += sum;
        }
        System.out.println(totalSum);
    }
}
