package org.example.week03.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1966 {
    /*
     * 1. 테스트케이스의 수와 문서의 갯수, 궁금한 문서의 초기 위치를 입력받음
     * 2. 입력받은 문서의 중요도를 큐에 저장하고, 문서의 위치와 중요도를 배열에 함께 저장
     * 3. 큐에서 문서를 하나씩 꺼내면서 해당 문서의 중요도보다 높은 문서가 있는지 확인
     * 4. 현재 문서의 중요도가 가장 높다면 출력할 순서 증가
     * 5. 궁금한 문서의 순서를 찾을 때까지 이 과정을 반복하고 결과 출력
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수를 입력받음

        for (int i = 0; i < T; i++) { // 테스트 케이스의 수만큼 반복
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서의 갯수를 입력받음
            int M = Integer.parseInt(st.nextToken()); // 궁금한 문서의 초기 위치를 입력받음

            Queue<Integer> queue = new LinkedList<Integer>();// 중요도 저장 큐
            st = new StringTokenizer(br.readLine());
            int[] priorities = new int[N]; // 중요도 저장 배열

            for (int j = 0; j < N; j++) { // 문서의 수(N)만큼 반복하여 각 문서의 중요도를 저장
                int priority = Integer.parseInt(st.nextToken()); // 중요도를 입력받음
                priorities[j] = priority; // 중요도를 배열에 저장
                queue.add(priority); // 큐에도 중요도를 저장
            }
            int count = 0; // 출력할 순서를 세는 변수
            while (!queue.isEmpty()) { // 큐가 빌 때까지 반복
                int now = queue.remove(); // 큐에서 중요도를 꺼냄
                boolean flag = true; // 큐에 남아있는 문서들과 현재 문서의 중요도 비교를 위한 플래그

                for (int priority : queue) { // 큐에 남아있는 문서들과 현재 문서의 중요도를 비교
                    if (priority > now) { // 더 큰 중요도를 가진 문서가 있다면
                        flag = false; // flag를 false로 변경
                        break; // 반복문 탈출
                    }
                }
                if (flag) { // 현재 문서의 중요도가 가장 높다면
                    count++; // 출력할 순서 증가
                    if (queue.isEmpty()) break; // 큐가 비어있다면 반복문 탈출
                    if (M == 0) break; // 현재 문서가 궁금한 문서라면 반복문 탈출
                } else { // 현재 문서의 중요도보다 더 높은 문서가 큐에 있다면
                    queue.add(now); // 큐의 마지막에 현재 문서를 추가
                }
                M--; // 궁금한 문서의 위치 갱신
                if (M < 0) M = queue.size() - 1; // 위치가 음수가 되면 마지막으로 이동
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb.toString());
    }
}


