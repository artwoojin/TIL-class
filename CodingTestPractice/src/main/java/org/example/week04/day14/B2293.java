package org.example.week04.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2293 {
    /*
    ***** 문제 설명 : n가지 종류의 동전이 있다. 각 동전의 가치는 다르다.
    *     이 동전을 적당히 사용해서 가치의 합이 k원이 되게 하고 싶다.
    *     그 경우의 수를 구하시오. 각 동전은 무한대로 사용할 수 있다.
    *     사용한 동전의 구성이 같은데 순서만 다른 것은 같은 경우이다.
    *
    ***** 입출력 : 첫째 줄에 n, k가 주어진다. (1 ≤ n ≤ 100, 1 ≤ k ≤ 10,000)
    *     다음 n개의 줄에는 각각의 동전의 가치가 주어진다.
    *     동전의 가치는 100,000보다 작거나 같은 자연수이다.
    *     첫째 줄에 경우의 수를 출력한다. 경우의 수는 2의 31승보다 작다.
    *
    ***** 풀이 설계 :
    *     가장 작은 가치의 동전부터 시작해서 목표 금액을 만드는 경우의 수를 저장하는 배열을 만든다.
    *     각 동전에 대해 반복하면서 현재 동전을 사용하여 각각의 금액을 만들 수 있는 경우의 수를 구한다.
    *     1부터 목표 금액까지 반복하면서 현재 금액에서 현재 동전의 가치를 뺀 금액을 만드는 경우의 수를 더한다.
    *     모든 동전에 대해서 위 과정을 반복하면 dp 배열의 마지막 요소는 목표 금액을 만들 수 있는 경우의 수이다.
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 동전의 종류 갯수
        int k = Integer.parseInt(st.nextToken()); // 목표 금액
        int[] dp = new int[k + 1]; // k원을 만들 수 있는 경우의 수

        for (int i = 0; i < n; i++) { // 각 동전에 대해 반복
            int coin = Integer.parseInt(br.readLine()); // 동전의 가치 입력
            for (int j = 1; j <= k; j++) { // 1원부터 목표 금액까지 반복하여 경우의 수 계산
                if (j - coin > 0) { // 현재 동전을 사용하여 j원을 만들 수 있는 경우
                    dp[j] = dp[j] + dp[j - coin]; // 현재 금액에서 동전의 가치를 뺀 금액을 만들 수 있는 경우의 수를 더함
                } else if (j - coin == 0) { // 현재 동전의 가치가 j원과 같은 경우
                    dp[j]++; // 경우의 수를 1 증가시킴
                }
            }
        }
        System.out.println(dp[k]);
    }
}
