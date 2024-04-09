package org.example.week03.codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1863 {
    /*
    ***** 문제 설명 : 직사각형 모양의 건물들이 모여 이루는 스카이라인을 보고
    *     건물이 최소한 몇 채인지 알아낸다.
    ***** 입출력 : 첫째 줄에 n(1 ≤ n ≤ 50,000)이 입력된다.
    *     다음 n개의 줄에는 왼쪽부터 스카이라인을 훑어볼 때 그 고도가 바뀌는 지점의 좌표 x,y가 입력된다.
    *     (1 ≤ x ≤ 1,000,000. 0 ≤ y ≤ 500,000) 첫번째 지점의 x좌표는 항상 1이다.
    *     첫 줄에 최소 건물 갯수를 출력한다.
    ***** 풀이 설계 : 건물의 고도가 바뀌는 지점의 좌표 x,y를 입력받아서
    *     입력 받은 건물의 고도가 달라지는 지점의 좌표 중 높이인 y를 기준으로
    *     스택이 비어있지 않은 동안 건물의 갯수를 센다.
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 입력받을 건물의 수
        int count = 0; // 최소 건물의 갯수

        Stack<Integer> stack = new Stack<>(); // 건물의 높이 저장용 스택
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            // 현재 건물의 x, y좌표를 입력받음
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 스택이 비어있지 않고, 스택의 맨 위 높이가 현재 건물의 높이와 같다면 다음 건물로 넘어감
            if (!stack.isEmpty() && stack.peek() == y) continue;

            // 스택이 비어있지 않고, 스택의 맨 위 높이가 현재 건물의 높이보다 높은 경우
            // 건물 갯수 증가, 스택에서 꺼냄
            while (!stack.isEmpty() && stack.peek() > y) {
                count++;
                stack.pop();
            }
            // 현재 건물의 높이를 스택에 추가
            stack.push(y);
        }

        // 남아있는 건물의 높이에 대해 처리
        // 스택이 비어있지 않은 동안 스택의 맨 위 높이가 0보다 큰 경우
        // 건물의 갯수를 증가시키고 스택에서 꺼냄
        while (!stack.isEmpty()) {
            if (stack.peek() > 0) {
                count++;
            }
            stack.pop();
        }
        // 최종 건물의 갯수 출력
        System.out.println(count);
    }
}