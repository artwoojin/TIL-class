package org.example.week04.day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B8911 {
    /*
    ***** 문제 설명 : 상근이는 2차원 평면 위에서 움직이는 거북이 로봇이 있다.
    *     거북이 로봇에게 내릴 수 있는 명령은 다음과 같이 네 가지이다.
    *     1. F: 한 눈금 앞으로, 2. B: 한 눈금 뒤로, 3. L: 90도 좌회전, R: 90도 우회전
    *     L,R 명령을 내렸을 때 로봇은 이동하기 않고 방향만 바꾼다.
    *     명령을 나열한 것을 거북이 로봇의 컨트롤 프로그램이라고 한다.
    *     거북이는 항상 x, y축에 평행한 방향으로만 이동한다.
    *     거북이가 지나간 영역을 모두 포함할 수 있는 가장 작은 직사각형의 넓이를 구한다.
    *     (직사각형의 모든 변은 x축이나 y축에 평행이어야 한다.)
    *     거북이의 처음 위치는 (0,0)이고, 북쪽을 바라보고 있다.
    *     그리고 거북이가 지나간 영역이 직사각형을 만들지 않고 선분이 될 때는 넓이가 0이다.
    ***** 입출력 : 첫째 줄에 테스트 케이스의 개수 T가 입력된다.
    *     각 테스트 케이스는 한 줄로 이루어져 있고, 컨트롤 프로그램이 입력된다.
    *     프로그램은 항상 문제의 설명에 나와있는 네 가지 명령으로만 이루어져 있고, 길이는 500을 넘지 않는다.
    *     각 테스트 케이스에 대해서 거북이가 이동한 영역을 모두 포함하는 가장 작은 직사각형의 넓이를 출력한다.
    ***** 풀이 설계 : 좌우 방향을 어떻게 이동할 지에 대해서 막혔습니다.
    * */

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int x = 0, y = 0, nowX = 0, nowY = 0, direction = 0;
            String command = br.readLine();
            for (int j = 0; j < command.length(); j++) {
                char c = command.charAt(j);

                if (c == 'F') {
                    nowX = nowX + dx[direction];
                    nowY = nowY + dy[direction];
                } else if (c == 'B') {
                    nowX = nowX - dx[direction];
                    nowY = nowY - dy[direction];
                } else if (c == 'L') {
                    // todo
                } else if (c == 'R') {
                    // todo
                }

            }
        }
    }
}
