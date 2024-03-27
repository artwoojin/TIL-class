package org.example.week02.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String grade[] = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};
        double score[] = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0};

        double result = 0;
        double gradeScore = 0;

        for (int i = 0; i < 20; i++) {
            String str[] = br.readLine().split(" ");
            if (!str[2].equals("P")) {
                result += score[Arrays.asList(grade).indexOf(str[2])] * Double.parseDouble(str[1]);
                gradeScore += Double.parseDouble(str[1]);
            }
        }
        System.out.printf("%.6f", result / gradeScore);

    }
}

