package org.example.week04.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B13164 {
    /*
    ***** 문제 설명 : 행복 유치원
    *     N명의 유치원생들을 키 순서대로 일렬로 줄 세우고, 총 K개의 조로 나누려고 한다.
    *     각 조에는 원생이 적어도 한 명 있어야 하고, 같은 조에 속한 원생들은 서로
    *     인접해 있어야 한다. 조별로 인원수가 같을 필요는 없다.
    *     이렇게 나눠진 조들은 각자 단체 티셔츠를 맞추려는데,
    *     그 비용은 조에서 가장 키가 큰 원생과 가장 키가 작은 원생의 키 차이만큼 든다.
    *     최대한 비용을 아끼고 싶어하는 태양이는 K개의 조에 대해 티셔츠 만드는 비용의 합을
    *     최소로 하고 싶어한다. 최소의 비용을 구하자.
    *
    ***** 입출력 : 입력의 첫 줄에는 유치원생의 수인 자연수 N(1 ≤ N ≤ 300,000)과
    *     나누려고 하는 조의 개수를 나타내는 자연수 K(1 ≤ K ≤ N)가 공백으로 구분되어 주어진다.
    *     다음 줄에는 원생들의 키를 나타내는 N개의 자연수가 공백으로 구분되어 줄 서 있는 순서대로 주어진다.
    *     태양이는 원생들을 키 순서대로 줄 세웠으므로, 왼쪽에 있는 원생이 오른쪽에 있는 원생보다 크지 않다.
    *     원생의 키는 10의 9승을 넘지 않는 자연수이다.
    *     이 때 티셔츠 만드는 비용이 최소가 되도록 K개의 조로 나눴을 때, 티셔츠 만드는 비용을 출력한다.
    *
    ***** 풀이 설계 : Arraylist에 원생들의 키와 키 차이를 저장하고, 오름차순으로 정렬해서
    *     가장 키 차이가 많이 나는 K-1를 제외하고 나머지 값들을 합한다.
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);
        String[] heights = br.readLine().split(" ");
        ArrayList<Integer> height = new ArrayList<>();
        ArrayList<Integer> difference = new ArrayList<>();

        for (String heightStr : heights) {
            height.add(Integer.parseInt(heightStr));
        }
        Collections.sort(height);

        for (int i = 0; i < N - 1; i++) {
            difference.add(height.get(i + 1) - height.get(i));
        }
        Collections.sort(difference);

        int result = 0;
        for (int i = 0; i < N - K; i++) {
            result += difference.get(i);
        }
        System.out.println(result);
    }
}
