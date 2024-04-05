package org.example.week03.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2805 {
    /*
    * 0. 문제 설명 : 절단기에 높이 H를 지정하면 톱날이 땅으로부터 H미터 위로 올라간다.
    *    그 후 한 줄에 연속해 있는 나무를 모두 절단하는데, 높이가 H미터보다 큰 나무는
    *    H 위의 부분이 잘린다. 상근이는 나무를 필요한 만큼만 집으로 가져가고 싶다.
    *    그가 가져가려는 나무는 총 M미터이다.
    * 1. 나무의 수 N, 가져가려는 나무의 길이 M 입력받음
    * 2. 나무의 높이를 배열 trees로 저장
    * 3. 잘라진 나무의 높이 합 sum은 항상 M보다 크거나 같음
    *    (나무를 못 가져가는 경우는 없음)
    * 4. 적어도 M미터의 나무를 가져가기 위해서 절단기 설정 높이의 최대값을 구해야 하므로,
    *    중간값 mid로 높이를 설정했을 때의 sum을 구함
    * 5. sum이 M보다 작으면 높이를 낮춰야 하고, M 이상이면 높이를 높여야 함
    * 6. 최적값 = 절단기 설정 높이 최대값 출력
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 나무의 수
        long M = Long.parseLong(st.nextToken()); // 가져가려는 나무의 길이

        long[] trees = new long[N]; // 나무의 높이 저장
        long max = 0L; // 나무 중 최대 높이
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Long.parseLong(st.nextToken()); // 나무의 높이를 배열에 저장
            max = Math.max(max, trees[i]); // 최대 나무 높이 갱신
        }

        long start = 0L;
        long end = max; // 절단기의 끝 높이 = 최대 나무 높이로 초기화

        while (start <= end) {
            long mid = (start + end) / 2L; // 중간값 계산
            long sum = 0L; // 잘린 나무의 길이 합

            for (int i = 0; i < N; i++) {
                if (trees[i] > mid) { // mid보다 높은 나무만 잘림
                    sum += trees[i] - mid; // 잘린 길이를 합산
                }
            }
            if (sum >= M) { // 잘린 나무의 길이 합이 M 이상이면
                start = mid + 1; // 절단기 높이 증가시킴
            } else { // 잘린 나무의 길이 합이 M 미만이면
                end = mid - 1; // 절단기 높이 감소시킴
            }
        }
        System.out.println(end);
    }
}