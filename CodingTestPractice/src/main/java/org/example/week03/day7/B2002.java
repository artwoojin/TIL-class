package org.example.week03.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2002 {
    /*
    * 1. 차의 대수 N, 터널에 들어간 차량 번호 목록, 터널에서 나온 차량 번호 목록 입력받음
    * 2. 위 두 개의 목록을 Queue에 저장
    * 3. 이후 그 두 개의 목록에서 하나씩 번호를 꺼내서 비교
    * 4. 꺼낸 번호가 서로 다르면 추월 예상 차량의 수 증가시킨 후
    * 5. 터널에 들어간 차량 번호 목록에서도 해당 차량 번호 제거
    * 6. 꺼낸 번호가 서로 같으면 두 개의 목록에서 해당 차량 번호 제거
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 차의 대수

        // 터널에 들어간 순서대로 차량 번호를 Queue에 추가
        Queue<String> input = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            input.add(br.readLine());
        }

        // 터널에서 나온 순서대로 차량 번호를 Queue에 추가
        Queue<String> output = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            output.add(br.readLine());
        }

        int count = 0; // 추월 예상 차량의 수
        while(!output.isEmpty() && !input.isEmpty()) {
            // 터널에서 나온 차량 큐에서 가장 앞 차량을 꺼냄
            String Tunnelout = output.poll();

            // 터널에 들어간 차량 큐에서 조회한 가장 앞 차량 != 나온 차들 중 가장 앞 차량인 경우
            if(!input.peek().equals(Tunnelout)) {
                count++; // 추월 예상 차량의 수 증가
                input.remove(Tunnelout); // 터널에서 나온 차량번호를 들어간 차량 큐에서 제거
            } else {
                // 터널에 들어간 차량 큐에서 조회한 가장 앞 차량 = 터널에서 나온 차량이면
                // 터널에 들어간 차량 큐에서도 해당 차량을 제거
                input.poll();
            }
        }
        br.close();
        System.out.println(count);
    }
}
