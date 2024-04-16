package org.example.week04.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1713 {
    /* 틀렸습니다.
    ***** 문제 설명 : 월드초등학교 학생회장 후보는 학생 추천에 의해서 선정된다.
    *     학교 홈페이지에서 추천받은 학생의 사진을 게시할 수 있는 사진틀을 후보 수만큼 만들었다.
    *     추천받은 학생의 사진을 사진틀에 게시하고 추천받은 횟수를 표시하는 규칙은 다음과 같다.
    *     1) 학생들이 추천을 시작하기 전, 모든 사진틀은 비어있다.
    *     2) 추천을 받은 학생은 사진이 반드시 사진틀에 게시되어야 한다.
    *     3) 비어있는 사진틀이 없는 경우, 현재까지 추천 횟수가 가장 적은 학생의 사진을 삭제한다.
    *     그리고 그 자리에 새롭게 추천받은 학생의 사진을 게시한다. 이 때, 추천 횟수가 가장 적은
    *     학생이 두 명 이상이면 그런 학생들 중 게시된지 가장 오래된 사진을 삭제한다.
    *     4) 현재 사진이 게시된 학생이 다른 학생의 추천을 받은 경우, 추천 횟수만 증가시킨다.
    *     5) 사진틀에 게시된 사진이 삭제되는 경우, 해당 학생이 추천받은 횟수는 0으로 바뀐다.
    *     후보의 수, 즉 사진틀의 갯수와 전체 학생의 추천 결과가 추천받은 순서대로 주어질 때
    *     최종 후보가 누구인지 결정하는 프로그램을 작성한다.
    *
    ***** 입출력 : 첫째 줄에는 사진틀의 갯수 N (1 ≤ N ≤ 20)이 입력된다.
    *     둘째 줄에는 전체 학생의 총 추천 횟수가, 셋째 줄에는 추천받은 학생을 나타내는 번호가
    *     빈 칸을 사이에 두고 추천받은 순서대로 주어진다. 총 추천 횟수는 1,000번 이하이며,
    *     학생을 나타내는 번호는 1부터 100까지의 자연수이다.
    *     이 때 사진틀에 사진이 게재된 최종 후보의 학생 번호를 증가하는 순서대로 출력한다.
    *
    ***** 풀이 설계 : 후보를 나타내는 Student 클래스를 만든다.
    *     각 후보의 학생 번호, 추천 횟수, 게시된 시간을 저장한다.
    *     사진 게시 여부를 확인하고, 이미 게시된 학생이면 추첫 횟수만 증가시킨다.
    *     게시가 아직 안 된 학생인데, 빈 사진틀이 있는 경우면 후보 리스트에 추가한다.
    *     만약 사진틀이 꽉 찬 상황이면 추천 횟수가 가장 적은 후보를 찾아서 없앤다.
    *     만약 추천 횟수가 가장 적은 후보가 두 명 이상이면, 오래된 후보를 없앤다.
    *     그 없앤 자리에 지금 학생을 추가한다.
    *
    * */

    static class Student implements Comparable<Student> {
        int num; // 학생 번호
        int recommendations; // 추천 횟수
        int time; // 게시된 시간

        public Student(int num, int recommendations, int time) {
            this.num = num;
            this.recommendations = recommendations;
            this.time = time;
        }

        @Override
        public int compareTo(Student o) {
            if (this.recommendations == o.recommendations) {
                return Integer.compare(this.time, o.time); // 시간 오름차순
            }
            return Integer.compare(this.recommendations, o.recommendations); // 추천 횟수 오름차순
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 처리
        int N = Integer.parseInt(br.readLine()); // 사진틀의 갯수
        int totalRecommendations = Integer.parseInt(br.readLine()); // 전체 학생의 총 추천 횟수
        String[] recommendations = br.readLine().split(" ");

        // 각 학생의 추천 횟수를 저장하는 배열
        int[] studentRecommendations = new int[101]; // 학생 번호는 1부터 100까지

        // 후보를 저장하는 리스트
        List<Student> candidates = new ArrayList<>();

        // 입력 받은 추천 정보를 처리
        for (int time = 0; time < totalRecommendations; time++) {
            int studentNum = Integer.parseInt(recommendations[time]); // 추천 받은 학생 번호

            // 해당 학생의 추천 횟수를 1 증가시킴
            studentRecommendations[studentNum]++;

            // 이미 게시된 학생인지 확인
            boolean isPosted = false;
            for (Student student : candidates) {
                if (student.num == studentNum) {
                    student.recommendations++; // 이미 게시된 학생이면 추천 횟수만 증가
                    isPosted = true;
                    break;
                }
            }

            // 게시가 안 된 학생인 경우
            if (!isPosted) {
                if (candidates.size() < N) { // 빈 사진틀이 있는 경우, 후보 저장 리스트에 추가
                    candidates.add(new Student(studentNum, studentRecommendations[studentNum], time));
                } else { // 사진틀이 꽉 찬 경우
                    // 추천 횟수가 가장 적은 후보를 찾음
                    Collections.sort(candidates); // 후보 리스트 오름차순 정렬
                    Student leastRecommended = candidates.get(0);
                    // 최소 추천 횟수를 가진 후보가 여러 명일 경우, 가장 오래된 후보를 삭제
                    for (int j = 1; j < candidates.size(); j++) {
                        if (candidates.get(j).recommendations == leastRecommended.recommendations) {
                            if (candidates.get(j).time < leastRecommended.time) {
                                leastRecommended = candidates.get(j);
                            }
                        } else {
                            break;
                        }
                    }
                    // 후보 리스트에서 삭제
                    candidates.remove(leastRecommended);
                    // 새로운 학생 추가
                    candidates.add(new Student(studentNum, studentRecommendations[studentNum], time));
                }
            }
        }

        // 후보를 게시한 순서대로 출력
        List<Integer> result = new ArrayList<>();
        for (Student student : candidates) {
            result.add(student.num);
        }
        Collections.sort(result);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}