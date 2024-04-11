package org.example.week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1182 {
    /*
     ***** 문제 설명 : N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서
     *     그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구한다.
     ***** 입출력 : 첫째 줄에 정수의 개수를 나타내는 N, 정수 S가 입력된다.(1 ≤ N ≤ 20, |S| ≤ 1,000,000)
     *     둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 입력된다. (|N| ≤ 100,000)
     *     이 때, 첫째 줄에 합이 S가 되는 부분수열의 개수를 출력한다.
     ***** 풀이 설계 : N, S를 입력받고 N개의 정수를 입력받아 배열에 저장한다.
     *     배열에 저장한 N개의 정수를 탐색하면서 원소를 선택했을 때와 선택하지 않았을 때의 합이 S가 되면 count를 증가시키고,
     *     그렇지 않으면 다음 탐색을 진행한다. 이 과정을 반복해서 전체 부분수열을 탐색하고 그 때의 count값을 출력한다.
     * */

    static int N, S, count; // 입력받을 정수의 개수(N), 목표 합(S), 부분수열 개수를 카운트할 변수(count)를 선언
    static int[] arr; // 입력받은 정수를 저장할 배열

    // DFS 탐색으로 부분수열을 찾는 메서드
    public static void dfs(int index, int sum) {
        // 배열의 모든 원소를 확인했을 때
        if (index == N) {
            // 합이 목표값(S)와 같으면 count를 증가시키고 메서드 종료
            if (sum == S) {
                count++;
            }
            return; // 메서드 종료
        }
        // 현재 원소를 포함하는 경우와 포함하지 않는 경우에 대해 호출
        dfs(index + 1, sum + arr[index]); // 현재 원소를 포함하는 경우
        dfs(index + 1, sum); // 현재 원소를 포함하지 않는 경우
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 첫 번째 입력 값(N)을 정수로 변환하여 변수에 저장
        S = Integer.parseInt(st.nextToken()); // 두 번째 입력 값(S)을 정수로 변환하여 변수에 저장
        arr = new int[N]; // N개의 정수를 저장할 배열 생성

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        // 만약 합이 0인 부분수열을 구한 경우, count에서 1을 뺀 값을 출력하고
        // 그렇지 않은 경우에는 count 값을 출력
        System.out.println(S == 0 ? count - 1 : count);
    }
}

