package org.example.week04.day13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B1931 {
    /*
     ***** 문제 설명 : 회의실 배정
     *     한 개의 회의실을 사용하고자 하는 N개의 회의에 대해 사용표를 만들고자 한다.
     *     각 회의 I에 대해 시작시간과 끝나는 시간이 주어져있고,
     *     각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾는다.
     *     회의는 시작되면 중간에 중단되지 않고, 한 회의가 끝나는 동시에 다음 회의가 시작될 수 있다.
     *     회의의 시작 시간과 끝나는 시간이 같을 수도 있다. 이 경우는 시작하자마자 끝나는 것이다.
     *
     ***** 입출력 : 첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 입력된다.
     *     둘째 줄부터 N+1번째 줄까지 공백을 사이에 두고 각 회의의 시작 시간과 종료 시간이 입력된다.
     *     0 ≤ 시작 시간, 종료 시간 ≤ 2의 31승 -1 이다.
     *     이 때, 첫째 줄에 최대 사용할 수 있는 회의의 최대 갯수를 출력한다.
     *
     ***** 풀이 설계 : <회의를 종료 시간이 빠른 순서대로(오름차순으로) 우선순위큐에 저장한다.>
     *     이전 회의의 종료 시간보다 다음 회의의 시작 시간이 늦어야 한다.
     *     이 조건을 만족하는 회의의 수를 카운팅해서, 출력한다.
     * */

    // 회의 정보 저장 클래스
    private static class Meeting {
        int start; // 회의 시작 시간
        int end; // 회의 종료 시간
        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 회의의 수

        // 우선순위큐에 회의를 저장, 종료 시간을 기준으로 정렬
        PriorityQueue<Meeting> queue = new PriorityQueue<>(new Comparator<Meeting>() {
            @Override
            public int compare(Meeting m1, Meeting m2) {
                // 종료 시간이 같으면 시작 시간을 기준으로 오름차순 정렬
                if (m1.end == m2.end) {
                    return m1.start - m2.start;
                }
                // 종료 시간이 다르면 끝나는 시간을 기준으로 오름차순 정렬
                return m1.end - m2.end;
            }
        });

        int prevEnd = 0; // 이전 회의의 종료 시간
        int maxCount = 0; // 선택된 회의의 수

        // 입력된 회의 정보를 우선순위 큐에 저장
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            queue.offer(new Meeting(start, end)); // 우선순위 큐에 새로운 회의 객체 추가
        }

        // 가능한 회의 선택하기
        while (!queue.isEmpty()) {
            Meeting meeting = queue.poll(); // 가장 먼저 종료되는 회의를 우선순위 큐에서 꺼냄
            // 현재 회의의 시작 시간이 이전 회의의 종료 시간보다 늦거나 같으면
            if (meeting.start >= prevEnd) {
                prevEnd = meeting.end; // 회의의 종료 시간 갱신
                maxCount++; // 선택된 회의 수 증가
            }
        }
        System.out.println(maxCount);
    }
}
