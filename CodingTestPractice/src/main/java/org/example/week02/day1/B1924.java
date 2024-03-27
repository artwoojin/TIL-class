package org.example.week02.day1;

import java.util.Scanner;

public class B1924 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        int[] daysOfMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] daysOfWeeks = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        int day = 0;
        for (int i = 0; i < x - 1; i++) {
            day += daysOfMonths[i];
        }

        int result = (day + y) % 7;
        System.out.println(daysOfWeeks[result]);
    }
}
