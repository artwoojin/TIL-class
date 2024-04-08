package org.example.week03.day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1072 {
    /* 런타임 에러(NumberFormat)
     * 0. 문제 설명 : 형택이는 게임을 이제까지 이길 때도 있었고, 질 때도 있었다.
     *    하지만 이제 형택이는 지지 않는다. 게임 횟수 X와 이긴 횟수 Y를 입력받을 때,
     *    Z는 승률이다. 이 때, 형택이가 최소 몇 번의 게임을 해야 Z가 변하는지 구한다.
     *    만약, Z가 절대 변하지 않는다면 -1을 출력한다.
     * 1. 풀이 설계 : 승률 = 이긴 횟수 / 게임 횟수 * 100 이고, 소수점은 버린다.
     *    앞으로 해야 할 게임의 최댓값은 게임 횟수로 두고(여기는 잘 모르겠다.)
     *    중간값을 잡아서 나온 승률과 원래의 승률을 비교하여 이분탐색을 한다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        double Z = (double) Y / X * 100;

        int start = 0;
        int end = X;
        int result = 0;
        while (start <= end){
            if (Z >= 99.0) {
                result = -1;
                break;
            }
            int mid = (start + end) / 2;
            double newZ = (double) (Y + mid) / (X + mid) * 100;

            if (Z >= newZ) {
                start = mid + 1;
            } else {
                end = mid - 1;
                result = Math.min(result, mid);
            }
        }
        System.out.println(result);
    }
}

