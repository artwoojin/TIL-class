package org.example.week02.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 터널에 들어간 차량 번호를 Queue에 추가
        Queue<String> in = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            in.add(br.readLine());
        }

        // 터널에서 나온 순서대로 차량 번호를 Queue에 추가
        Queue<String> out = new LinkedList<>();
        for(int i=0; i<N; i++) {
            out.add(br.readLine());
        }

        int result = 0;
        while(!out.isEmpty()) {
            String Tunnelout = out.poll(); // 터널에서 나온 차 중 가장 앞 차량을 가져옴
            if(!in.peek().equals(Tunnelout)) { // 들어간 차 중 가장 앞에 있는 차량과 나온 차 중 가장 앞에 있는 차량이 다른 경우
                result++;
                in.remove(Tunnelout); // 나온 차량을 들어간 차 Queue에서 제거
            } else {
                in.poll(); // 터널에서 나온 차량 = 들어간 차 Queue의 가장 앞에 있는 차량이면 두 Queue에서 해당 차량을 제거
            }
        }
        br.close();
        System.out.println(result); // 최종 정답 출력
    }
}