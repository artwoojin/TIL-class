package org.example.week03.day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class B19638 {
    /*
    * 0. 문제 설명 : 뿅망치를 맞으면 그 사람의 키가 절반으로 줄어든다.
    *    뿅망치는 횟수 제한이 있기 때문에 매번 가장 큰 거인 가운데 하나를 때린다.
    *    거인 나라의 모든 거인이 센티보다 키가 작도록 하려면 어떻게 해야하는가?
    *    (단, 키가 1인 경우 더 줄어들 수 없어서 뿅망치의 영향을 받지 않는다.)
    * 1. 풀이 설계 : 거인 나라의 인구수 N(int), 센티의 키 hCenti(int),
    *    뿅망치의 횟수 제한 T가 빈 칸을 사이에 두고 한 줄로 주어진다.
    *    두 번째 줄~N개의 줄에 각 거인의 키 H가 주어진다.
    *    -> hArr 배열에 저장 후 내림차순 정렬 --> 정렬 두 번이라 시간초과남
    *    1) 횟수 제한보다 사용 횟수가 적거나 같고 센티보다 모든 거인의 키가 작은 경우,
    *       성공이므로 첫째줄에 YES 출력, 둘째줄에 뿅망치를 최소로 사용한 횟수 출력
    *    2) 그 외의 경우, 실패이므로 첫째줄에 NO 출력, 둘째줄에 뿅망치 사용 이후
    *       거인 나라에서 키가 가장 큰 거인의 키를 출력
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int hCenti = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] hArr = new int[N];
        for (int i = 0; i < N; i++) {
            hArr[i] = Integer.parseInt(br.readLine());
        }
        int[] sortedArr = IntStream.of(hArr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        int maxHit = 0; // 뿅망치 사용 횟수 초기화
        int largestGiant = sortedArr[0]; // 가장 큰 거인의 키
        boolean success = true;
        // 뿅망치 사용 횟수를 구하고, 성공 여부를 판단
        for (int i = 0; i < N; i++) {
            int currentGiant = sortedArr[i];
            if (currentGiant <= hCenti) break; // 센티보다 키가 작은 거인이 있으면 종료
            if (maxHit == T) {
                success = false;
                break; // 뿅망치 사용 횟수가 제한에 도달하면 종료
            }
            sortedArr[i] /= 2; // 뿅망치를 맞은 거인의 키를 절반으로 줄임
            maxHit++; // 뿅망치 사용 횟수 증가
            // 정렬을 유지하기 위해 다시 정렬
            sortedArr = IntStream.of(sortedArr)
                    .boxed()
                    .sorted(Comparator.reverseOrder())
                    .mapToInt(Integer::intValue)
                    .toArray();
            largestGiant = sortedArr[0]; // 가장 큰 거인의 키 업데이트
        }

        // 결과 출력
        if (success) {
            System.out.println("YES");
            System.out.println(maxHit);
        } else {
            System.out.println("NO");
            System.out.println(largestGiant);
        }
    }
}
