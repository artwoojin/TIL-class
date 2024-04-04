package org.example.week03.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 배열의 크기 입력
        StringTokenizer st = new StringTokenizer(br.readLine()); // 배열 입력

        Stack<Integer> stack = new Stack<>(); // 스택 생성. 인덱스를 저장

        for (int i = 1; i <= n; i++) {
            int currentValue = Integer.parseInt(st.nextToken()); // 현재 값
            while (!stack.isEmpty() && Integer.parseInt(st.nextToken()) < currentValue) {
                System.out.print(stack.pop() + " "); // 현재 값보다 작은 값의 인덱스를 출력
            }
            stack.push(i); // 현재 값의 인덱스를 스택에 저장
        }

        // 스택에 남아있는 값들은 오른쪽에 더 작은 값이 없는 경우이므로 0으로 출력
        while (!stack.isEmpty()) {
            System.out.print("0 ");
            stack.pop();
        }
    }
}
