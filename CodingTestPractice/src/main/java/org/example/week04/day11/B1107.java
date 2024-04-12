package org.example.week04.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1107 {
    /*
     ***** 문제 설명 : 수빈이의 TV 리모컨은 일부 숫자 버튼이 고장났다.
     *     리모컨 버튼은 숫자 0~9, +, -가 있다. +를 누르면 현재 채널에서 +1 된 채널로 이동하고,
     *     -1을 누르면 현재 채널에서 -1 된 채널로 이동한다. 채널 0에서 -를 누르면 변하지 않는다.
     *     채널은 무한대 만큼 있고, 수빈이가 지금 이동하려고 하는 채널은 N이다.
     *     어떤 버튼이 고장났는지 주어졌을 때, 채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야 하는지 구한다.
     *     수빈이가 지금 보고 있는 채널은 100번이다.
     ***** 입출력 : 첫째 줄에 수빈이가 이동하려고 하는 채널 N (0 ≤ N ≤ 500,000)이,
     *     둘째 줄에 고장난 버튼의 개수 M(0 ≤ M ≤ 10)이 입력된다.
     *     고장난 버튼이 있으면 셋째 줄에 고장난 버튼이 입력되고, 같은 버튼이 여러 번 주어지는 경우는 없다.
     *     이 때, 첫째 줄에 채널 N 으로 이동하기 위해서 버튼을 최소 몇 번 눌러야 하는지 출력한다.
     ***** 풀이 설계 : 모든 경우의 수를 탐색해야 하기 때문에 dfs로 탐색한다.
     *
     * */


    // 주어진 채널로 이동이 가능한지 확인하고, 버튼을 몇 번 눌러야 하는지 반환하는 메서드
    private static int possible(int N, int num, boolean[] broken) {
        if (num == 0) { // 채널이 0인 경우
            if (broken[0]) return -1; // 버튼이 고장났으면 불가능하므로 -1 반환
            return 1; // 아니면 0으로 바로 이동 가능하므로 1 반환
        }
        int press = 0; // 버튼 누른 횟수 초기화
        while (num > 0) { // 채널 번호를 하나씩 확인하며
            if (broken[num % 10]) return -1; // 고장난 버튼이 있는지 확인해서 불가능하면 -1 반환
            press++; // 가능하다면 버튼 누른 횟수 증가
            num /= 10; // 다음 자릿수 확인을 위해 나누기
        }
        return press; // 모든 자릿수에 대해 버튼을 누를 수 있으면 버튼을 누른 횟수 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 이동하려는 채널
        int size = Integer.parseInt(br.readLine()); // 고장난 버튼의 개수

        boolean[] broken = new boolean[10]; // 고장난 버튼을 체크할 배열

        // 고장난 버튼의 개수가 0보다 크면, 해당 버튼들을 입력받아 배열에 표시
        if (size > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        // 초기값 설정: 현재 채널(100)에서 이동하려는 채널까지의 거리
        int result = Math.abs(N - 100);

        // 모든 가능한 경우를 탐색하여 최소 횟수를 찾음
        for (int i = 0; i <= 1000000; i++) {
            // 고장난 버튼을 고려하여 해당 채널로 이동하기 위해 눌러야 하는 횟수를 계산
            int press = possible(N, i, broken);
            if (press > -1) { // 가능한 채널일 때
                // 이동한 횟수와 숫자 버튼을 누른 횟수를 합산하여 총 횟수 계산
                int total = Math.abs(N - i) + press;
                result = Math.min(result, total); // 최소 횟수 갱신
            }
        }
        System.out.println(result);
    }

}



