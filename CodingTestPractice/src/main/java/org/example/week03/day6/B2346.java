package org.example.week03.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B2346 {
    /* 1. 풍선의 숫자를 Deque에 저장
     * 2. 첫 번째 풍선을 터뜨리고, 해당 풍선 안에 적힌 숫자만큼 이동
     * 3. 선택한 풍선의 번호를 결과에 추가하고, 다음 풍선을 현재 풍선으로 설정
     * 4. 남아있는 풍선이 없을 때까지 2~3번 과정을 반복하고 결과 출력
     * 미완성 코드
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> balloons = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 풍선의 숫자를 큐에 넣음
        for (int i = 1; i < N; i++) {
            balloons.add(Integer.parseInt(st.nextToken()));
        }

        // 처음 풍선을 터뜨림
        int current = balloons.poll();
        sb.append(1).append(" ");

        while (!balloons.isEmpty()) {
            int next;

            if (current > 0) { // 현재 풍선의 숫자가 양수인 경우
                next = current % balloons.size();

                current = balloons.pollFirst(); // 다음 풍선을 가져옴
            } else { // 현재 풍선의 숫자가 음수인 경우
                next = Math.abs(current) % balloons.size();

                current = balloons.pollLast(); // 다음 풍선을 가져옴
            }
            System.out.println(sb.toString());
        }
    }
}


//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//
//        Deque<Integer> balloons = new ArrayDeque<>();
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        StringBuilder sb = new StringBuilder();
//        sb.append("1 "); // 첫 번째 풍선은 항상 터뜨릴 수 있음
//
//        // 두 번째 풍선부터 Deque에 저장
//        for(int i = 1; i < n; i++) {
//            balloons.add(Integer.parseInt(st.nextToken()));
//        }
//
//        int current = balloons.poll(); // 현재 풍선을 가져옴
//
//        while(!balloons.isEmpty()) {
//            int next;
//
//            if(current > 0) { // 현재 풍선의 숫자가 양수인 경우
//                next = current % balloons.size(); // 다음 풍선의 인덱스 계산
//                if(next == 0) // 나머지가 0인 경우, 마지막 풍선을 터뜨림
//                    next = balloons.size();
//                sb.append(next + 1).append(" "); // 다음 풍선의 인덱스를 결과에 추가
//                while(next-- > 0) { // 다음 풍선 이전의 풍선들은 빼고 다시 넣음
//                    balloons.addLast(balloons.pollFirst());
//                }
//                current = balloons.pollFirst(); // 다음 풍선을 가져옴
//            } else { // 현재 풍선의 숫자가 음수인 경우
//                next = Math.abs(current) % balloons.size(); // 다음 풍선의 인덱스 계산
//                if(next == 0) // 나머지가 0인 경우, 마지막 풍선을 터뜨림
//                    next = balloons.size();
//                sb.append(next + 1).append(" "); // 다음 풍선의 인덱스를 결과에 추가
//                while(next-- > 0) { // 다음 풍선 이전의 풍선들은 빼고 다시 넣음
//                    balloons.addFirst(balloons.pollLast());
//                }
//                current = balloons.pollLast(); // 다음 풍선을 가져옴
//            }
//        }
//
//        System.out.println(sb.toString());