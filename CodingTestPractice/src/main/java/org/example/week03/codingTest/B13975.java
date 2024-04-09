package org.example.week03.codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B13975 {
    /*
    ***** 문제 설명 : 여러 개의 파일로 나뉜 소설 중 각 두 개씩 반복적으로 합쳐서 최종 한 파일로 만든다.
    *     이 과정에서 두 개의 파일을 합쳐서 하나의 임시 파일로 만들고, 이 임시파일이나 원래의 파일을
    *     계속 두 개씩 합쳐서 파일을 합쳐나가고, 최종적으로 하나의 파일로 합친다.
    *     두 개의 파일을 합칠 때 필요한 비용이 두 파일 크기의 합이라고 가정하고,
    *     최종 한 개의 파일을 만드는데 필요한 비용의 총 합을 계산한다.
    ***** 입출력 : 첫째 줄에 테스트 케이스의 갯수 T를 입력 받고, 각 테스트 데이터는 두 개의 행으로 입력받는다.
    *     테스트 데이터의 첫 행에는 소설을 구성하는 장의 수를 나타내는 양의 정수 K가 입력된다.
    *     두 번째 행에는 1~K장까지 수록한 파일의 크기를 나타내는 양의 정수 K개가 주어진다.
    *     파일의 크기는 10,000을 초과하지 않는다.
    *     각 테스트 데이터마다 정확히 한 행에 출력하는데, 모든 장을 합치는 데 필요한 최소비용을 출력한다.
    ***** 풀이 설계 : 우선순위 큐를 사용해서 오름차순 정렬을 하면서 K들을 저장한다.
    *     큐의 크기가 1이 될 때까지 두 파일들을 꺼내서 합친 후 그 크기를 다시 큐에 넣는 작업을 반복한다.
    *     이 때 파일 크기의 값들을 누적합해나가고, 큐의 크기가 1이 되었을 때의 누적합을 출력한다.
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 갯수

        for (int i = 0; i < T; i++) { // 각 테스트 케이스에 대해 반복
            long result = 0; // 각 테스트 케이스의 결과값
            int K = Integer.parseInt(br.readLine()); // 소설을 구성하는 장의 수
            StringTokenizer st = new StringTokenizer(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>(); // 파일 크기들을 저장할 우선순위 큐 생성
            for (int j = 0; j < K; j++) { // 각 파일의 크기를 우선순위 큐에 저장
                pq.add(Long.parseLong(st.nextToken()));
            }

            while (!pq.isEmpty()) { // 우선순위 큐가 빌 때까지 반복
                if (pq.size() == 1) break; // 큐에 남은 파일이 하나일 때 반복문 종료
                long sum = pq.poll() + pq.poll(); // 가장 작은 두 파일을 꺼내서 합침
                result += sum; // 비용 누적
                pq.add(sum); // 합친 파일 크기를 큐에 추가
            }
            System.out.println(result);
        }
    }
}