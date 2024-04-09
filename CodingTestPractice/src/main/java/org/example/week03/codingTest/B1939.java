package org.example.week03.codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1939 {
    /*
    ***** 문제 설명 : N(2 ≤ N ≤ 10,000)개의 섬으로 이루어진 나라의 영식 중공업에서는
    *     두 개의 섬에 공장을 세우고 물품을 생산하는데 한 공장에서 다른 섬의 공장으로 물품을 수송해야 한다.
    *     서로 같은 두 섬 사이에 여러 다리가 있을 수도 있고, 모든 다리는 양방향이다
    *     마지막 줄에는 공장이 위치해 있는 섬의 번호를 나타내는 서로 다른 두 정수가 입력된다.
    *     이 때, 한 번의 이동에서 옮길 수 있는 물품 중량의 최댓값을 구한다.
    ***** 입출력 : 첫째 줄에 섬의 갯수 N, 다음 M개의 줄에는 세 정수 A,B,C가 입력된다.
    *     이는 A,B번 섬 사이에 중량제한이 C(1 ≤ C ≤ 1,000,000,000)인 다리가 존재한다는 의미이다.
    *     출력 첫째 줄에 한 번의 이동에서 옮길 수 있는 물품 중량의 최댓값을 출력한다.
    ***** 풀이 설계 : ArrayList[n+1]로 graph 생성 및 입력값을 받는다.
    *     low를 1로, high를 다리들 중 최대 중량으로 설정해서 이분탐색을 시작한다.
    *     이분탐색 while문을 반복하며
    * 이동 가능한 중량의 최댓값을 구한다.
    * */

    public static int N; // 섬의 개수
    public static int M; // 다리의 개수
    // 섬과 연결된 다리 정보를 저장하는 리스트
    public static ArrayList<ArrayList<Bridge>> bridge = new ArrayList<>();
    public static int max = 0; // 모든 다리의 최대 중량 중 최대값

    // 섬과 해당 섬으로 옮길 수 있는 물품의 중량을 저장하는 클래스
    static class Bridge{
        int island; // 해당 다리가 연결하는 섬의 번호
        int weight; // 해당 다리를 통해 운반 가능한 물품의 최대 중량
        public Bridge(int island, int weight) { // 다리 객체 생성자
            this.island = island; // 다리가 연결하는 섬의 번호 초기화
            this.weight = weight; // 다리를 통해 옮길 수 있는 물품의 최대 중량 초기화
        }
    }

    // 주어진 중량으로 a에서 b까지 갈 수 있는지 확인하는 bfs 함수
    public static boolean bfs(int start, int end, int mid) {
        boolean[] visit = new boolean[N+1]; // 각 섬을 방문했는지 여부를 저장하는 배열
        Queue<Integer> q = new LinkedList<>(); // bfs 탐색을 위한 큐
        q.add(start); // 출발지 섬을 큐에 추가
        visit[start] = true; // 출발지 섬 방문 처리

        // bfs 탐색
        while(!q.isEmpty()) {
            int p = q.poll(); // 큐에서 섬 번호를 꺼냄

            if(p == end) { // 도착지에 도달했다면
                return true; // true 반환하여 해당 중량으로 이동 가능함을 표시
            }

            // 현재 섬과 연결된 다리들을 탐색하며 중량을 확인하고, 이동 가능한 경우 큐에 추가
            for(Bridge i: bridge.get(p)) {
                if(!visit[i.island] && mid <= i.weight) { // 아직 방문하지 않았고, 현재 중량으로 이동 가능한 경우
                    visit[i.island] = true; // 해당 섬 방문 처리
                    q.add(i.island); // 큐에 추가하여 다음에 방문할 섬으로 설정
                }
            }
        }
        return false; // 도착지에 도달하지 못했다면 false 반환하여 해당 중량으로는 이동 불가능함을 표시
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 받기 위한 BufferedReader 객체 생성
        StringTokenizer st = new StringTokenizer(br.readLine()); // 입력을 공백으로 구분하여 토큰화

        N = Integer.parseInt(st.nextToken()); // 섬의 개수 입력
        M = Integer.parseInt(st.nextToken()); // 다리의 개수 입력

        // 섬과 연결된 다리 정보를 저장하기 위한 ArrayList 초기화
        for(int i=0;i<=N;i++) {
            bridge.add(new ArrayList<>());
        }

        // 모든 다리 정보를 입력받아 저장
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 다리가 연결된 첫 번째 섬의 번호
            int b = Integer.parseInt(st.nextToken()); // 다리가 연결된 두 번째 섬의 번호
            int c = Integer.parseInt(st.nextToken()); // 해당 다리를 통해 운반 가능한 물품의 최대 중량

            // 양방향으로 연결되어 있기 때문에 각 섬에 다리 정보를 추가해줌
            bridge.get(a).add(new Bridge(b,c));
            bridge.get(b).add(new Bridge(a,c));

            // 모든 다리의 최대 중량 중 최댓값을 업데이트
            if(max < c) {
                max = c;
            }
        }

        // 출발지와 도착지 입력
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); // 출발지 섬의 번호
        int end = Integer.parseInt(st.nextToken()); // 도착지 섬의 번호

        int low = 0; // 이진 탐색을 위한 최솟값
        int high = max; // 이진 탐색을 위한 최댓값 = 다리 최대 중량의 최댓값

        // 이진 탐색 수행
        while(low <= high) {
            int mid = (low + high)/2; // 현재 중량의 중간값 계산
            if(bfs(start,end,mid)) { // bfs 함수를 통해 중량이 mid일 때 a에서 b로 갈 수 있는지 확인
                low = mid + 1; // 가능하다면 더 큰 중량을 탐색하기 위해 왼쪽 경계를 이동
            } else {
                high = mid - 1; // 불가능하다면 더 작은 중량을 탐색하기 위해 오른쪽 경계를 이동
            }
        }
        System.out.println(high); // 최종 결과 출력
    }
}
