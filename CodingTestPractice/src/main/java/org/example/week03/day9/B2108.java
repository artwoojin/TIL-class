package org.example.week03.day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class B2108 {
    /*
    * 0. 문제 설명 : N개의 수들이 주어지면 다음 네 개의 값을 출력한다.(N은 홀수)
    *    1) 산술평균(N개의 수들의 합을 N으로 나눈 값)
    *    2) 중앙값(N개의 수들을 오름차순으로 나열했을 경우 그 중앙에 위치하는 값)
    *    3) 최빈값(N개의 수들 중 가장 많이 나타나는 값)
    *    4) 범위(N개의 수들 중 최댓값과 최솟값의 차이)
    * 1. 풀이 설계 : N을 첫째줄에서 입력받은 후 for문으로 N개의 줄에 있는 정수들을 입력받음
    *    입력 받은 정수들을 배열 arr에 저장 후 네 개의 값 연산
    *    1) 스트림 sum 메서드로 배열 arr 요소들의 합 구한 후 N으로 나눔
    *    2) 배열을 정렬한 뒤에 수의 갯수/2 번째 값을 구함
    *    3) Map을 이용해 key:입력받은 수, value:빈도 수 저장해서 최대 값 가진 key 출력
    *    4) 오름차순한 배열의 가장 끝번쨰 수 - 가장 첫번째 수
    * */

    public static void main(String[] args) throws IOException {
        //--------값 입력받는 부분----------//
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        //--------1) 산술 평균----------//
        int sum = Arrays.stream(arr).sum();
        int avg = sum / N;
        System.out.println(Math.round(avg));

        //--------2) 중앙값----------//
        Arrays.sort(arr);
        System.out.println(arr[N / 2]);

        //--------3) 최빈값----------//
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {

        }

        //--------4) 범위----------//
        System.out.println(arr[N - 1] - arr[0]);
    }
}

