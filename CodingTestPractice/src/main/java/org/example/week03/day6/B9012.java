package org.example.week03.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B9012 {
    /*
     * 1. 입력 데이터 수에 따라 반복하며 각각의 괄호 문자열을 처리
     * 2. 주어진 괄호 문자열이 올바른 괄호 문자열인지 판단하기 위해 스택을 활용
     * 3. 여는 괄호 '('가 나오면 스택에 추가
     * 4. 닫는 괄호 ')'가 나오면 스택에 최근에 추가된 괄호를 제거
     * 5. 괄호 문자열을 모두 확인한 후에 스택이 비어있으면 올바른 괄호 문자열로 판단
     * 6. 스택이 비어있지 않으면 괄호가 올바르지 않은 것으로 판단
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());// 입력 데이터의 수

        for (int i = 0; i < T; i++) {
            String str = br.readLine(); // 괄호 문자열

            // 괄호 문자열이 올바른지 확인하여 결과 출력
            System.out.println(vps(str) ? "YES" : "NO");
        }
    }

    /*
     * 주어진 문자열이 vps인지 확인하는 메서드
     * str 확인할 문자열
     * vps이면 true, 아니면 false
     * */
    static boolean vps(String str) {
        // 괄호의 짝을 저장하기 위한 스택
        Stack<Character> stack = new Stack<>();

        // 문자열의 각 문자를 순회하며 괄호 짝을 확인
        for (char c : str.toCharArray()) {
            if (c == '(') { // 여는 괄호일 때
                stack.push(c); // 스택에 추가
            } else { // 닫는 괄호일 때
                // 스택이 비어있는 경우, 짝이 안 맞으므로 틀림
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop(); // 짝이 맞는 괄호를 스택에서 제거
            }
        }
        // 모든 문자를 확인한 후에도 스택이 비어있으면 vps
        return stack.isEmpty();
    }
}

