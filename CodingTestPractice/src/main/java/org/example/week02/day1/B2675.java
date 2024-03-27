package org.example.week02.day1;

import java.util.Scanner;

public class B2675 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();

        for(int i = 0; i < line; i++) {
            int R = scanner.nextInt();
            String S = scanner.next();

            for(int j = 0; j < S.length(); j++) {
                for(int k = 0; k < R; k++) {
                    System.out.print(S.charAt(j));
                }
            }

            System.out.println();
        }
    }

}
