package org.example.week02.day4;

import java.io.*;

public class B5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split("");
        int[] index = new int[M];
        int indexArr = 0;

        // 입력 문자열을 순회하면서 'I' 문자의 인덱스를 찾아 index 배열에 저장
        for (int i = 0; i < M; ++i) {
            if (str[i].equals("I")) {
                index[indexArr] = i;
                indexArr++;
            }
        }

        int count = 0;
        int result = 0;
        // 'I' 문자의 인덱스 배열을 순회하며 연속된 패턴의 개수를 계산
        for (int i = 1; i < indexArr; ++i) {
            if (index[i] - index[i - 1] == 2) {
                count++;
            } else {
                count = 0;
            }
            // 연속된 패턴의 개수가 N 이상일 경우 result 수 증가
            if (count >= N) {
                result++;
            }
        }
        bw.write("" + result + "\n");
        bw.close();
        br.close();
    }
}
