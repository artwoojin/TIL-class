package org.example.week02.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int line = 0; // line = 행의 번호
        int count = 0; // count = X가 속한 행의 번호
        int top = 1; // top = 분자
        int bottom = 1; // bottom = 분모

        // X = 1인 경우
        if (X == 1) {
            System.out.println("1/1");
        } else {
            // X = 1이 아닌 경우는 아래 while문 실행
            while (count < X) {
                line++; // 행을 1씩 증가시키면서 몇 번째 행인지 계산
                count = line * (line +1) / 2; // X가 몇 번째 행에 있는지 계산
            }

            // X가 있는 행에서 X가 몇 번째에 있는지 계산
            int num = X - (line - 1) * line / 2;

            // 행이 짝수인 경우
            if (line % 2 == 0) {
                top = num;
                bottom = line - num + 1;
            } else { // 행이 홀수인 경우
                top = line - num + 1;
                bottom = num;
            }
            System.out.println(top + "/" + bottom);
        }

    }
}
