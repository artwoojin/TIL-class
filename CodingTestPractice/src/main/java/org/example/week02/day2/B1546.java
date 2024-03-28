package org.example.week02.day2;

import java.util.Scanner;

public class B1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double score[] = new double[N];
        double M = 0d; // 최고점
        double avg = 0d; // 평균

        for (int i = 0; i < N; i++) {
            score[i] = sc.nextInt();
            if (score[i] > M) {
                M = score[i];
            }
        }

        for (int j = 0; j < score.length; j++) {
            avg += (score[j]/M*100)/N;
        }
        System.out.println(avg);
    }
}
