package org.example.week03.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B9375 {
    /*
     * 1. 테스트 케이스 횟수 T와
     * 2. 해빈이가 가진 의상의 수 N을 입력받고,
     * 3. 해빈이가 가진 의상의 이름과 종류가 공백으로 구분되어 입력됨
     * 4. 서로 다른 조합을 가진 경우의 수를 구함
     * 5. 단, 의상 한 종류당 갯수는 하나씩만 허용됨
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 횟수

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine()); // 의상의 수
            // 의상의 종류와 개수를 저장할 해시맵 생성
            HashMap<String, Integer> fashion = new HashMap<>();

            for (int j = 0; j < N; j++) { // 각 의상에 대해 반복
                st = new StringTokenizer(br.readLine());
                st.nextToken(); // 첫 토큰은 의상의 이름이므로 사용하지 않음
                String costume = st.nextToken(); // 두 번째 토큰은 의상의 종류
                // 의상의 종류가 맵에 없으면 +1, 있으면 그 value값에 +1해서 해시맵에 저장
                fashion.put(costume, fashion.getOrDefault(costume, 0) + 1);
            }

            int count = 1; // 서로 다른 조합의 수
            for (Map.Entry<String, Integer> entry : fashion.entrySet()) {
                // 각 의상의 종류에 대한 조합 수를 곱함
                // (아예 그 종류의 의상을 입지 않는 경우를 포함하기 위해서 +1 해서 곱함 - null)
                count *= entry.getValue() + 1;
            }
            sb.append(count - 1).append("\n"); // 아무 의상도 입지 않은 경우를 뺀 결과를 문자열에 추가
        }
        System.out.println(sb);
    }
}
